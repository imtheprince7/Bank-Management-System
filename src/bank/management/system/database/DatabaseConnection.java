package bank.management.system.database;

import java.sql.SQLException;
import java.sql.*;

public class DatabaseConnection {

    public static Connection ConnectionString() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management_system", "root", "admin");

        if (connection != null) {
            System.out.println("Connected...");
        } else {
            System.out.println("not Connected...");
        }
        return connection;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionString();
    }

}
