/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.valid;

import Model.entitites.Library;
import Model.exceptions.LibraryException;

/**
 *
 * @author jc
 */
public class ValidLibrary {

    public Library ValidLibrary(String name, String id_book) {
        Library library = new Library();
        
        if(name.isEmpty()) {
            throw new LibraryException("Error - Name is empty!");
        }
        
        library.setName(name);
        
        if(id_book.isEmpty()) {
            throw new LibraryException("Error - Id_book is empty!");
        }
        
        library.setId_book(id_book);
        
        return library;
    }
    
    
}
