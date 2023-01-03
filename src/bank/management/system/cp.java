package bank.management.system;
import java.sql.*;
 public  class cp {
    public static Connection con;

    public static Connection  createCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bankManagementSystem", "root","admin");
            // st = connec.createStatement();
            System.out.println("Con done");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
       
    }
    
}
