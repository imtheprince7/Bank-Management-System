/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system.database;
import java.sql.SQLException;
import java.sql.*;
public class Connection {
    public static java.sql.Connection Connect1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management_system","root","admin");
        if(connection!=null)
            System.out.println("Connect");
        else
            System.out.println("not Connect");
        return connection;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connect1();
    }

}