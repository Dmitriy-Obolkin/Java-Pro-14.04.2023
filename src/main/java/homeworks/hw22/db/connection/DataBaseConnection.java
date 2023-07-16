package homeworks.hw22.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private final String url;
    private final String user;
    private final String password;

    public DataBaseConnection(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the connection!\n" + e.getMessage());
            }
        }
    }

}
