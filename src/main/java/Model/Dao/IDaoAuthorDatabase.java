package Model.Dao;

import Model.entitites.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IDaoAuthorDatabase implements IDao<Author> {
    private Connection connection;

    public IDaoAuthorDatabase(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Author author) {
        String sql = "INSERT INTO author (cpf, name, hometown) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, author.getCpf());
            stmt.setString(2, author.getName());
            stmt.setString(3, author.getHometown());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar autor: " + e.getMessage());
        }
    }

    @Override
    public void update(String cpf, Author newAuthor) {
        String sql = "UPDATE author SET cpf = ?, name = ?, hometown = ? WHERE cod = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newAuthor.getCpf());
            stmt.setString(2, newAuthor.getName());
            stmt.setString(3, newAuthor.getHometown());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar autor: " + e.getMessage());
        }
    }

    @Override
    public void delete(String cpf) {
        String sql = "DELETE FROM author WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar autor: " + e.getMessage());
        }
    }

    @Override
    public Author find(String cpf) {
        String sql = "SELECT * FROM author WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Author(
                            rs.getString("cpf"),
                            rs.getString("name"),
                            rs.getString("hometown")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar autor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Author> findAll() {
        String sql = "SELECT * FROM author";
        List<Author> listAuthors = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listAuthors.add(new Author(
                        rs.getString("cpf"),
                        rs.getString("name"),
                        rs.getString("hometown")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar autor: " + e.getMessage());
        }
        return listAuthors;
    }

}
