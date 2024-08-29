package Controller;

import Model.Dao.IDao;
import Model.entitites.Book;
import Model.entitites.Author;
import Model.valid.ValidBook;
import java.util.List;

public class BookController {

    private IDao repository;

    public BookController(IDao repository) {
        this.repository = repository;
    }

    // Método para adicionar um livro
    public void addBook(String id, String name, String author_id) {

        ValidBook validation = new ValidBook();
        Book validatedBook = validation.validateBook(id, name, author_id);

        if (validatedBook != null) {
            Book foundBook = (Book) repository.find(id);

            if (foundBook == null) {
                
                // Salvar no repositório (ex: arquivo, banco de dados)
                repository.save(validatedBook);

                
                System.out.println("Book add with sucess.");
            } else {
                System.out.println("A book with this ID already exists.");
            }
        } else {
            System.out.println("Invalid data for the book54.");
        }
    }

    // Método para remover um livro pelo ID
    public void removeBook(String id) {
        Book foundBook = (Book) repository.find(id);

        if (foundBook != null) {
            repository.delete(id);
                       
            System.out.println("Book Removed with sucess.");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    // Método para atualizar um livro pelo ID
    public void updateBook(String id, Book newBook) {
        ValidBook validation = new ValidBook();
        Book validatedBook = validation.validateBook(newBook.getId(), newBook.getName(), newBook.getAuthorId());

        if (validatedBook != null) {
            Book oldBook = (Book) repository.find(id);

            if (oldBook != null) {
                
                repository.update(id, newBook);

                System.out.println("Book update with sucess.");
            } else {
                System.out.println("Book not fouded for update.");
            }
        } else {
            System.out.println("Data invalid for update");
        }
    }

    // Método para listar todos os livros
    public List<Book> listBooks() {
        return repository.findAll();
    }
}
