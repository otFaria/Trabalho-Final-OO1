package Model.valid;

import Model.entitites.Book;
import Model.exceptions.BookException;

public class ValidBook {

    public Book validateBook(String cod_book, String name, String author_id) {
        
        Book book = new Book();

        // Verificar se o ID do livro não está vazio
        if (cod_book.isEmpty()) {
            throw new BookException("Error - Field empty");
        }
        
        book.setCod_book(cod_book);

        // Verificar se o nome do livro não está vazio
        if (name.isEmpty()) {
            throw new BookException("Error - Field empty");
        }
        book.setName(name);

        // Verificar se o autor do livro não é nulo
        if (author_id.isEmpty()) {
           throw new BookException("Error - Field empty");
        }
        
        book.setAuthorID(author_id);

        return book;
    }
}

