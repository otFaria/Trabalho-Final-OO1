package Controller;

import Model.Dao.IDao;
import Model.entitites.Book;
import Model.entitites.Author;
import Model.exceptions.BookException;
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
                throw new BookException("A book with this ID already exists.");
            }
        } else {
            throw new BookException("Invalid data for the book");
        }
    }

    // Método para remover um livro pelo ID
    public void removeBook(String id) {
        Book foundBook = (Book) repository.find(id);

        if (foundBook != null) {
            repository.delete(id);
                       
            System.out.println("Book Removed with sucess.");
        } else {
            throw new BookException("Book not found!");
        }
    }

    // Método para atualizar um livro pelo ID
    public void updateBook(String cod_book, Book newBook) {
        ValidBook validation = new ValidBook();
        Book validatedBook = validation.validateBook(newBook.getCod_book(), newBook.getName(), newBook.getAuthorId());

        if (validatedBook != null) {
            Book oldBook = (Book) repository.find(cod_book);

            if (oldBook != null) {
                
                repository.update(cod_book, newBook);

                System.out.println("Book update with sucess.");
            } else {
                throw new BookException("Book not found for update");
            }
        } else {
            throw new BookException("Data invalid for update");
        }
    }

    // Método para listar todos os livros
    public List<Book> listBooks() {
        return repository.findAll();
    }
}
