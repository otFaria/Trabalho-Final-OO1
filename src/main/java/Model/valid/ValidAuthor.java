package Model.valid;

import Model.entitites.Author;
import Model.exceptions.AuthorException;

public class ValidAuthor {
    
    public Author ValidAuthor(String cpf, String name, String hometown){
        
        Author author = new Author();
        
        if (cpf.isEmpty()){
            throw new AuthorException("Error - Field empty!");
        }

        author.setCpf(cpf);

        if(name.isEmpty()){
            throw new AuthorException("Error - Field empty!");
        }

        author.setName(name);

        if(hometown.isEmpty()){
            throw new AuthorException("Error - Field empty!");
        }

        author.setHometown(hometown);

        return author;
    }
}