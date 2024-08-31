/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.file.SerializerLibrary;

import Model.entitites.Library;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author jc
 */
public class ISerializerJSONLibrary {
    
    public String toFile(List<Library> listLibrary) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonData = mapper.writeValueAsString(listLibrary);
            
            return jsonData;
        
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Library> fromFile(String jsonData) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Library> listLibrary = mapper.readValue(
                    jsonData,
                    new TypeReference<List<Library>>() {});
            
            return listLibrary;
        
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
