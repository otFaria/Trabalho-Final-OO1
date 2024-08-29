package Model.valid;

import Model.entitites.Book;
import Model.exceptions.BookException;

public class ValidBook {

    public Book validateBook(String id, String name, String author_id) {
        
        Book book = new Book();

        // Verificar se o ID do livro não está vazio
        if (id.isEmpty()) {
            throw new BookException("Error - Field empty");
        }
        
        book.setId(id);

        // Verificar se o nome do livro não está vazio
        if (name.isEmpty()) {
            throw new BookException("Error - Field empty");
        }
        book.setName(name);

        // Verificar se o autor do livro não é nulo
        if (author_id.isEmpty()) {
           throw new BookException("Error - Field empty");
        }
        
        book.setAuthorID(id);

        return book;
    }
}

