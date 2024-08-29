package Model.Dao;

import Model.dao.IDao;
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
        String sql = "INSERT INTO book (id, name, author_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getId());
            stmt.setString(2, book.getName());
            stmt.setString(3, book.getAuthor().getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar livro: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Book newBook) {
        String sql = "UPDATE book SET id = ?, name = ?, author_name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newBook.getId());
            stmt.setString(2, newBook.getName());
            stmt.setString(3, newBook.getAuthor().getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM book WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar livro: " + e.getMessage());
        }
    }

    @Override
    public Book find(String id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String author_name =

                    return new Book(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("author_name")
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
        String sql = "SELECT * FROM author";
        List<Book> listAuthors = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listAuthors.add(new Book(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("author_name")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar autor: " + e.getMessage());
        }
        return listAuthors;
    }
}
