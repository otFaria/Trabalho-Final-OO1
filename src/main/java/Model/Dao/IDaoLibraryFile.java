/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.entitites.Author;
import Model.entitites.Book;
import Model.entitites.Library;
import Model.exceptions.BookException;
import Model.exceptions.LibraryException;
import Model.file.FilePersistence;
import Model.file.SerializerBook.ISerializerJSONBook;
import Model.file.SerializerLibrary.ISerializerJSONLibrary;
import Model.valid.ValidBook;
import Model.valid.ValidLibrary;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jc
 */
public class IDaoLibraryFile implements IDao<Library> {
    
    private ISerializerJSONLibrary serializer = new ISerializerJSONLibrary();
    private FilePersistence filePersistence = new FilePersistence();
    
    private String pathFile;

    public IDaoLibraryFile(String pathFile, ISerializerJSONLibrary serializer) {
        this.pathFile = pathFile;
        this.serializer = serializer;
    }
    
    @Override
    public void save(Library obj) {
        List<Library> listLib = findAll();
        listLib.add(obj);
        
        try {
            String jsonData = serializer.toFile(listLib);
            filePersistence.SaveToFile(pathFile, jsonData);
            System.out.println("Saved with success on file");
            
        } catch (IOException ex) {
            Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String name, Library newObj) {
        Library libFound = find(name);
        ValidLibrary valid = new ValidLibrary();
        
        if(libFound != null) {
            Library libValidated = valid.ValidLibrary(
                    newObj.getName(),
                    newObj.getId_book()
            );
            
            if(libValidated != null) {
                List<Library> listLib = findAll();
                libFound.setName(newObj.getName());
                libFound.setId_book(newObj.getId_book());
                
                try {
                    String jsonData = serializer.toFile(listLib);
                    filePersistence.SaveToFile(pathFile, jsonData);
                    
                } catch (IOException ex) {
                    Logger.getLogger(IDaoBookFile.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                throw new BookException("Invalid library!");
            }
        } else {
            throw new BookException("Invalid library!");
        }
    }

    @Override
    public void delete(String nome) {
        Library libraryRemoved = this.find(nome);
        
        if(libraryRemoved != null){
            List<Library> listLib = this.findAll();
            listLib.remove(libraryRemoved);
            
            //mesma rotina para que aprendemos nas aulas de persistencia
            String jsonData = serializer.toFile(listLib);
            
            try {
                filePersistence.SaveToFile(jsonData, pathFile);
                System.out.println("Library deleted with success.");
                
            } catch (IOException ex) {
                Logger.getLogger(IDaoLibraryFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new LibraryException("Error -> Library returned is null");
        }
    }

    @Override
    public Library find(String nome) {
        List<Library> listLib = findAll();
        
        for(Library lb : listLib) {
            if(lb.getName().equals(nome)) {
                return lb;
            }
        }
        return null;
    }

    @Override
    public List<Library> findAll() {
        
        try {
            String jsonData = filePersistence.LoadFromFile(pathFile);
            List<Library> listLib = serializer.fromFile(jsonData);
            
            return listLib;
            
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
