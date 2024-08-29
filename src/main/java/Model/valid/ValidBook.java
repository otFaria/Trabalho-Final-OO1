package Model.valid;

import Model.entitites.Book;

public class ValidBook {

    public Book validateBook(String id, String name, String author_id) {
        
        Book book = new Book();

        // Verificar se o ID do livro não está vazio
        if (id.isEmpty()) {
            // Tratar exceção: ID não pode ser vazio
            System.out.println("ID do livro não pode ser vazio.");
            return null;
        }
        book.setId(id);

        // Verificar se o nome do livro não está vazio
        if (name.isEmpty()) {
            // Tratar exceção: Nome não pode ser vazio
            System.out.println("Nome do livro não pode ser vazio.");
            return null;
        }
        book.setName(name);

        // Verificar se o autor do livro não é nulo
        if (author_id.isEmpty()) {
            // Tratar exceção: Autor não pode ser nulo
            System.out.println("ID Autor nulo");
            return null;
        }
        
        book.setAuthorID(id);

        return book;
    }
}

