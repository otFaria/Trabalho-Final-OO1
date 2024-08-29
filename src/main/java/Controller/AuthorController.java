package Controller;

import Model.Dao.IDao;
import Model.entitites.Author;
import Model.valid.ValidAuthor;
import java.util.List;

public class AuthorController {
    
    IDao repositorio;
    

    public AuthorController() {
        
    }
   
    
    //SAVE IN THE BD or FILE
    
    
    public void Add_Author(Author A1){
        
        Author validated = new Author();
        ValidAuthor validation = new ValidAuthor();
        validated = validation.ValidAuthor(A1.getCpf(), A1.getName(), A1.getHometown());
        
        Author finded = new Author();
        finded = (Author) repositorio.find(A1.getCpf());
        
        if (finded == null) {
           
            //Save file;
            
            //IDao.save();
            
        }else{
            System.out.println("Althor already registered");
        }
    }
    
    
    public void Remove_Author(String cpf){
        
        
        Author finded = (Author) repositorio.find(cpf);
         
        if (finded != null){
            List<Author> list_author = repositorio.findAll();
            list_author.remove(finded);
              System.out.println("Remove success");
              
              //Serializador Json
              
        }else{
              System.out.println("i didn't find this author ");
        }
    }
    
    public void Update_Author(String cpf, Author new_Author){
        
        ValidAuthor validation = new ValidAuthor();
        Author valided = validation.ValidAuthor(new_Author.getCpf(), new_Author.getName(), new_Author.getHometown());
        Author update = (Author) repositorio.find(cpf);
        
        if (update != null && valided != null){
                    
            List<Author> list_author = repositorio.findAll();
            int index = list_author.indexOf(update);
            
            list_author.set(index, valided);
            
            //IDao
            //Serializador JSON
            
        }else{
            System.out.println("Error Update Author!");
        }
    }
    
    public List<Author> List_Author(){
        return repositorio.findAll();
    }
}