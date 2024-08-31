package Connection.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLConnector {

    private Connection connection;

    public PostgreSQLConnector(String dbName) throws SQLException {
        String urlConnection = "jdbc:postgresql://localhost:8080/" + dbName;
        this.connection = DriverManager.getConnection(urlConnection);

        createTableBook();
        createTableAuthor();
        createTableLibrary();
    }

        public void createTableAuthor() {
        String sql = "CREATE TABLE IF NOT EXISTS author ("
                + "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "name VARCHAR(200) NOT NULL,"
                + "cpf VARCHAR(15) NOT NULL,"
                + "hometown VARCHAR(200) NOT NULL"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error connection database: " + e.getMessage());
        }
    }

    public void createTableBook() {
        String sql = "CREATE TABLE IF NOT EXISTS book ("
                + "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY"
                + "cod_book INT NOT NULL,"
                + "name VARCHAR(200) NOT NULL,"
                + "author_id INT REFERENCES author(id) ON DELETE CASCADE"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error connection database: " + e.getMessage());
        }
    }

    public void createTableLibrary() {
        String sql = "CREATE TABLE IF NOT EXISTS library ("
                + "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "name VARCHAR(100) NOT NULL,"
                + "cod_book INT REFERENCES book(cod_book) ON DELETE CASCADE"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error connection database: " + e.getMessage());
        }
    }
}