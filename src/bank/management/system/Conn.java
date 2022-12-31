package bank.management.system;
import java.sql.*;
 public  class Conn {
   static Connection connec = null;
    Statement st ;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connec = DriverManager.getConnection("jdbc:mysql://bankManagementSystem", "root","admin");
            // st = connec.createStatement();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
    }
    
}
