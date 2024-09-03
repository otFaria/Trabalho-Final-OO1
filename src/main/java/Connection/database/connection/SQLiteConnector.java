package Connection.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnector {

    private Connection connection;

    public SQLiteConnector(String dbName) throws SQLException {
        String urlConnection = "jdbc:sqlite:" + dbName;
        this.connection = DriverManager.getConnection(urlConnection);

        createTableBook();
        createTableAuthor();
        createTableLibrary();
    }

    public Connection getConnection() {
        return connection;
    }

    public void createTableAuthor() {
        String sql = "CREATE TABLE IF NOT EXISTS author ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "cpf TEXT NOT NULL,"
                + "hometown TEXT NOT NULL"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public void createTableBook() {
        String sql = "CREATE TABLE IF NOT EXISTS book ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "cod_book INTEGER NOT NULL,"
                + "name TEXT NOT NULL,"
                + "author_id INTEGER REFERENCES author(id) ON DELETE CASCADE"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public void createTableLibrary() {
        String sql = "CREATE TABLE IF NOT EXISTS library ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "cod_book INTEGER REFERENCES book(cod_book) ON DELETE CASCADE"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
