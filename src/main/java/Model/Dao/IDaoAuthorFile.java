/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.entitites.Author;
import Model.entitites.Book;
import Model.exceptions.AuthorException;
import Model.exceptions.BookException;
import Model.file.FilePersistence;
import Model.file.SerializerAuthor.ISerializerJSONAuthor;
import Model.valid.ValidAuthor;
import Model.valid.ValidBook;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jc
 */
public class IDaoAuthorFile implements IDao<Author> {
    private ISerializerJSONAuthor serializer = new ISerializerJSONAuthor();
    private FilePersistence filePersistence = new FilePersistence();
    
    private String pathFile;

    public IDaoAuthorFile(String pathFile, ISerializerJSONAuthor serializer) {
        this.pathFile = pathFile;
        this.serializer = serializer;
    }
    
    @Override
    public void save(Author obj) {
        List<Author> listAuthor = findAll();
        listAuthor.add(obj);
        
        try {
            String jsonData = serializer.toFile(listAuthor);
            filePersistence.SaveToFile(pathFile, jsonData);
            System.out.println("Saved with success on file");
            
        } catch (IOException ex) {
            Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String cpf, Author newObj) {
        Author authorFound = find(cpf);
        ValidAuthor valid = new ValidAuthor();
        
        if(authorFound != null) {
            Author bookValidated = valid.ValidAuthor(
                    newObj.getCpf(),
                    newObj.getName(), 
                    newObj.getHometown()
            );
            
            if(bookValidated != null) {
                List<Author> listBooks = findAll();
                authorFound.setName(newObj.getName());
                authorFound.setCpf(newObj.getCpf());
                authorFound.setHometown(newObj.getHometown());
                
                try {
                    String jsonData = serializer.toFile(listBooks);
                    filePersistence.SaveToFile(pathFile, jsonData);
                    
                } catch (IOException ex) {
                    Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                throw new AuthorException("Invalid author!");
            }
        } else {
            throw new AuthorException("Invalid author!");
        }
    }

    @Override
    public void delete(String id) {
        Author bookRemoved = find(id);
        
        if(bookRemoved != null) {
            List<Author> listAuthor = findAll();
            listAuthor.remove(bookRemoved);
            
            try {
                String jsonData = serializer.toFile(listAuthor);
                filePersistence.SaveToFile(pathFile, jsonData);
                
            } catch (IOException ex) {
                Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            throw new AuthorException("Author returned is null");
        }
    }

    @Override
    public Author find(String cpf) {
        List<Author> listAuthor = findAll();
        
        for(Author at : listAuthor) {
            if(at.getCpf().equals(cpf)) {
                return at;
            }
        }
        return null;
    }

    @Override
    public List<Author> findAll() {
        
        try {
            String jsonData = filePersistence.LoadFromFile(pathFile);
            List<Author> listAuthor = serializer.fromFile(jsonData);
            
            return listAuthor;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    @Override
    public void insert(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
