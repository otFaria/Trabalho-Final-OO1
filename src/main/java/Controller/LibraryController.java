/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dao.IDao;
import Model.entitites.Library;
import Model.exceptions.LibraryException;
import Model.valid.ValidLibrary;
import java.util.List;

/**
 *
 * @author jc
 */
public class LibraryController {
    private IDao repository;

    public LibraryController(IDao repository) {
        this.repository = repository;
    }
    
    //metodo para adicionar biblioteca
    public void addLibrary(String name, String id_book) {
        ValidLibrary validated = new ValidLibrary();
        
        Library library = validated.ValidLibrary(name, id_book);
    
        if(library != null) {
            Library libraryValidated = (Library) repository.find(name);
            
            if(libraryValidated != null) {
                repository.save(libraryValidated);
                
                System.out.println("Library added with success!");
            } else {
                throw new LibraryException("Error add library! Your object is null");
            }
        } else {
            throw new LibraryException("Error in your validated library");
        }
    }
    
    //metodo para remover a bliblioteca pelo nome
    public void removeLibrary(String name) {
        Library libraryWanted = (Library) repository.find(name);
        
        if(libraryWanted != null) {
            repository.delete(name);
            
            System.out.println("LIbrary deleted with success!");
        } else {
            throw new LibraryException("Error - Library not found!");
        }
    }
    
    //metodo para atualizar dados da biblioteca
    public void updateLIbrary(String name, Library newLibrary) {
        ValidLibrary validated = new ValidLibrary();
        Library libraryValidated = validated.ValidLibrary(newLibrary.getName(), newLibrary.getId_book());
        
        if(libraryValidated != null) {
            Library libraryWanted = (Library) repository.find(name);
            
            if(libraryWanted != null) {
                repository.update(name, newLibrary);
                
                System.out.println("LIbrary updated with success!");
            } else {
                throw new LibraryException("Error - Library not found");
            }
        } else {
            throw new LibraryException("Error - Your validated library returned is null");
        }
    }
    
    public List<Library> listLibrary() {
        return repository.findAll();
    }
    
    public void insertIntoLibrary(String cod_book) {
        repository.insert(cod_book);
    }
}
