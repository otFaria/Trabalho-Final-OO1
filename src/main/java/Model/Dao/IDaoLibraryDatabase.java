/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.entitites.Book;
import Model.entitites.Library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jc
 */
public class IDaoLibraryDatabase implements IDao<Library>{
    private Connection connection;

    public IDaoLibraryDatabase(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Library lib) {
        String sql = "INSERT INTO library (name, id_book) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, lib.getName());
            stmt.setString(2, lib.getId_book());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar biblioteca: " + e.getMessage());
        }
    }

    @Override
    public void update(String name, Library newLibrary) {
        String sql = "UPDATE library SET name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newLibrary.getName());
            stmt.setString(2, newLibrary.getId_book());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar biblioteca: " + e.getMessage());
        }
    }

    @Override
    public void delete(String name) {
        String sql = "DELETE FROM library WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar biblioteca: " + e.getMessage());
        }
    }

    @Override
    public Library find(String name) {
        String sql = "SELECT * FROM library WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Library(
                            rs.getString("name"),
                            rs.getString("id_book")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar biblioteca: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Library> findAll() {
        String sql = "SELECT * FROM library";
        List<Library> listLibrarys = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listLibrarys.add(new Library(
                        rs.getString("name"),
                        rs.getString("id_book")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar bibliotecas: " + e.getMessage());
        }
        return listLibrarys;
    }
}
