package bank.management.system.database;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlJoinsClasses {

    static String userName;
    static ArrayList<String> arr = new ArrayList<>();

    public static ArrayList<String> getAccountDetails() throws ClassNotFoundException, SQLException {
        Connection connection = DatabaseConnection.ConnectionString();
        Statement statement = connection.createStatement();
        try{
         String accountNumber = "SELECT account_details.account_number AS accountNumber, account_details.account_type AS accountType, user_details.name AS accountyName,"
                 + " user_details.username AS username , user_details.email_id AS userEmailId, user_details.mobile_no AS userContact FROM account_details LEFT JOIN user_details "
                    + "ON user_details.username = account_details.username";
        
        ResultSet resultSet = statement.executeQuery(accountNumber);
            if (resultSet.next()) {
               arr.add(resultSet.getString("accountyName"));
               arr.add(resultSet.getString("accountNumber"));
               arr.add(resultSet.getString("accountType"));
               arr.add(resultSet.getString("username"));
               arr.add(resultSet.getString("userEmailId"));
               arr.add(resultSet.getString("userContact"));
            }
            else{
                System.err.println("Coming errors from Database-> MySqlJoins");
            }
        }finally {
            statement.close();
            connection.close();
        }
        return arr;
    }

    public static String getUserName(String name) {
        return (userName = name);
    }

    public static String getaccountNumber() throws SQLException, ClassNotFoundException {
        String account_number = "";

        Connection connection = DatabaseConnection.ConnectionString();
        Statement statement = connection.createStatement();
        try {
            String accountNumber = "SELECT account_details.account_number FROM account_details LEFT JOIN user_details "
                    + "ON user_details.username = account_details.username";
            ResultSet resultSet = statement.executeQuery(accountNumber);
            if (resultSet.next()) {
                account_number = resultSet.getString("account_number");
            }
        } finally {
            statement.close();
            connection.close();
        }
        return account_number;
    }
    
    public static String getCurrentAmount()throws SQLException, ClassNotFoundException {
        String cuurent_amount = "";
        Connection connection = DatabaseConnection.ConnectionString();
        Statement statement = connection.createStatement();
        try {
            String cuurentAmount = "SELECT deposit_details.current_amount FROM deposit_details LEFT JOIN account_details "
                    + "ON account_details.account_number = deposit_details.account_number";
            ResultSet resultSet = statement.executeQuery(cuurentAmount);
            if (resultSet.next()) {
                cuurent_amount = resultSet.getString("current_amount");
            }
        } finally {
            statement.close();
            connection.close();
        }
        return cuurent_amount;
    }
    
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        getAccountDetails();
    }

}
