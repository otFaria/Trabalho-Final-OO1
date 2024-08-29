/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.file.SerializerAuthor;

import Model.entitites.Author;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author jc
 */
public class ISerializerJSONAuthor {
    
    public String toFile(List<Author> entitites) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(entitites);

        } catch (JsonProcessingException e) {
            System.out.println("Error Convert to JSON String: " + e.getMessage());
            return null;
        }
    }

    public List<Author> fromFile(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Author> authors = mapper.readValue(jsonString, new TypeReference<List<Author>>() {
            });

            return authors;

        } catch (JsonProcessingException e) {
            System.out.println("Error fromFileJSON: " + e.getMessage());
            return null;
        }
    }
}
