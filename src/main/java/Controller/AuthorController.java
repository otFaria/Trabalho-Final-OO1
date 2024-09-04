package Controller;

import Model.Dao.IDao;
import Model.entitites.Author;
import Model.exceptions.AuthorException;
import Model.valid.ValidAuthor;
import java.util.List;

public class AuthorController {

    private IDao repository;

    public AuthorController(IDao repository) {
        this.repository = repository;
    }

    // Método para adicionar um autor
    public void addAuthor(String cpf, String name, String hometown) {

        ValidAuthor validation = new ValidAuthor();
        Author validatedAuthor = validation.ValidAuthor(cpf, name, hometown);

        if (validatedAuthor != null) {
            Author foundAuthor = (Author) repository.find(cpf);

            if (foundAuthor == null) {
                // Salvar no repositório (ex: arquivo, banco de dados)
                repository.save(validatedAuthor);

                System.out.println("Author added with success.");
            } else {
                throw new AuthorException("An author with this CPF already exists.");
            }
        } else {
            throw new AuthorException("Invalid data - Your author returned is null");
        }
    }

    // Método para remover um autor pelo CPF
    public void removeAuthor(String cpf) {
        Author foundAuthor = (Author) repository.find(cpf);

        if (foundAuthor != null) {
            repository.delete(cpf);

            System.out.println("Author removed with success.");
        } else {
            throw new AuthorException("Author not found on database!");
        }
    }

    // Método para atualizar um autor pelo CPF
    public void updateAuthor(String cpf, Author newAuthor){
        ValidAuthor validation = new ValidAuthor();
        Author validatedAuthor = validation.ValidAuthor(newAuthor.getCpf(), newAuthor.getName(), newAuthor.getHometown());

        if (validatedAuthor != null) {
            Author oldAuthor = (Author) repository.find(cpf);

            if (oldAuthor != null) {
                repository.update(cpf, validatedAuthor);

                System.out.println("Author updated with success.");
            } else {
                throw new AuthorException("Error - your author returned is null!");
            }
        } else {
            System.out.println("Your validate author occoured an error");
        }
    }
    
    //Método para buscar um autor.
    
    public Author findAuthor(String cpf){
        
        return (Author) repository.find(cpf);
    }

    // Método para listar todos os autores
    public List<Author> listAuthors() {
        return repository.findAll();
    }
}
