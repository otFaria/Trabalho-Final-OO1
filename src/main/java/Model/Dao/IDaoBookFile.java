/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.entitites.Book;
import Model.exceptions.BookException;
import Model.file.FilePersistence;
import Model.file.SerializerBook.ISerializerJSONBook;
import Model.valid.ValidBook;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.FileException;

/**
 *
 * @author jc
 */
public class IDaoBookFile implements IDao<Book> {
    
    private ISerializerJSONBook serializer = new ISerializerJSONBook();
    private FilePersistence filePersistence = new FilePersistence();
    
    private String pathFile;

    public IDaoBookFile(String pathFile, ISerializerJSONBook serializer) {
        this.pathFile = pathFile;
        this.serializer = serializer;
    }
    
    @Override
    public void save(Book obj) {
        List<Book> listBooks = findAll();
        listBooks.add(obj);
        
        try {
            String jsonData = serializer.toFile(listBooks);
            filePersistence.SaveToFile(pathFile, jsonData);
            System.out.println("Saved with success on file");
            
        } catch (IOException ex) {
            Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id, Book newObj) {
        
        Book bookFound = find(id);
        ValidBook valid = new ValidBook();
        
        if(bookFound != null) {
            Book bookValidated = valid.validateBook(
                    newObj.getCod_book(),
                    newObj.getName(), 
                    newObj.getAuthorId()
            );
            
            if(bookValidated != null) {
                List<Book> listBooks = findAll();
                bookFound.setName(newObj.getName());
                bookFound.setCod_book(newObj.getCod_book());
                bookFound.setAuthorID(newObj.getAuthorId());
                
                try {
                    String jsonData = serializer.toFile(listBooks);
                    filePersistence.SaveToFile(pathFile, jsonData);
                    
                } catch (IOException ex) {
                    Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                throw new BookException("Invalid book!");
            }
        } else {
            throw new BookException("Invalid book!");
        }
    }

    @Override
    public void delete(String id) {
        Book bookRemoved = find(id);
        
        if(bookRemoved != null) {
            List<Book> listBooks = findAll();
            listBooks.remove(bookRemoved);
            
            try {
                String jsonData = serializer.toFile(listBooks);
                filePersistence.SaveToFile(pathFile, jsonData);
                
            } catch (IOException ex) {
                Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            throw new BookException("Book returned is null");
        }
    }

    @Override
    public Book find(String id) {
        List<Book> listBooks = findAll();
        
        for(Book bk : listBooks) {
            if(bk.getCod_book().equals(id)) {
                return bk;
            }
        }
        return null;
    }

    @Override
    public List<Book> findAll() {

        try {
            String jsonData = filePersistence.LoadFromFile(pathFile);
            List<Book> listBooks = serializer.fromFile(jsonData);
            return listBooks;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
