/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FilePersistence {
   
    //Save to File
    
    public void SaveToFile(String path , String json) throws IOException{
        
        FileWriter arq = new FileWriter(path);
        PrintWriter gravarArq = new PrintWriter(arq);
        
        gravarArq.print(json);
        
        arq.close();
        
    }
    
    //Load to File
    
    public String LoadFromFile(String path) throws FileNotFoundException{
        
        File f = new File(path);
        Scanner arquivoLido = new Scanner(f);
        
        arquivoLido.useDelimiter("\\Z");
        
        String linhaLida = "";
        
        while (arquivoLido.hasNext()){            
            linhaLida += arquivoLido.next();
        }
        
        arquivoLido.close();
        
        return linhaLida;
    }
}