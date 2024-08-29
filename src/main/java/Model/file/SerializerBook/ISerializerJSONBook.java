/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.file.SerializerBook;

import Model.entitites.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author jc
 */
public class ISerializerJSONBook {
 
    public String toFile(List<Book> books) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(books);
        } catch (JsonProcessingException e) {
            System.out.println("Error Convert to JSON String: " + e.getMessage());
            return null;
        }
    }

    public List<Book> fromFile(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Book> books = mapper.readValue(jsonString, new TypeReference<List<Book>>() {
            });
            return books;
        } catch (JsonProcessingException e) {
            System.out.println("Error fromFileJSON: " + e.getMessage());
            return null;
        }
    }
}
