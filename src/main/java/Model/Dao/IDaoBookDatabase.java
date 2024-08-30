package Model.Dao;

import Model.entitites.Author;
import Model.entitites.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IDaoBookDatabase implements IDao<Book> {
    private Connection connection;

    public IDaoBookDatabase(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Book book) {
        String sql = "INSERT INTO book (cod_book, name, author_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getCod_book());
            stmt.setString(2, book.getName());
            stmt.setString(3, book.getAuthorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar livro: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Book newBook) {
        String sql = "UPDATE book SET cod_book = ?, name = ?, author_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newBook.getCod_book());
            stmt.setString(2, newBook.getName());
            stmt.setString(3, newBook.getAuthorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    @Override
    public void delete(String cod_book) {
        String sql = "DELETE FROM book WHERE cod_book = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cod_book);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar livro: " + e.getMessage());
        }
    }

    @Override
    public Book find(String cod_book) {
        String sql = "SELECT * FROM book WHERE cood_book = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cod_book);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Book(
                            rs.getString("cod_book"),
                            rs.getString("name"),
                            rs.getString("author_id")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar autor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM book";
        List<Book> listBooks= new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listBooks.add(new Book(
                        rs.getString("cod_book"),
                        rs.getString("name"),
                        rs.getString("author_id")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar autor: " + e.getMessage());
        }
        return listBooks;
    }
}
