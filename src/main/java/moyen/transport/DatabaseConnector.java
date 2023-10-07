package moyen.transport;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private String jdbcUrl;
    private String username;
    private String password;
    private Connection connection;

    public DatabaseConnector() {

    }

    public void connect(String jdbcUrl, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl, username, password);
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

