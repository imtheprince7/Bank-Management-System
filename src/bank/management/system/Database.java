package bank.management.system;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    static Connection newcon=null;

    //  ArrayList<String> user = new ArrayList<>();
    public Database(Connection newco){
        newcon=newco;
    }
    public Database()
    {
 
    }

    public boolean saveData(ArrayList<String> us)
    {
         System.out.println("Saved DAta called");
//           for (String str : us)
//	      { 		      
//	           System.out.println(str); 		
//	      }
            try{
                Statement stmt=newcon.createStatement();
                //String que="insert into test (name, roll) values ('ravi', '39')";
                //PreparedStatement ps=newcon.prepareStatement();
                //Statement s=newcon.createStatement("insert into test (name, roll) values ('prince', '30')");
                int result=stmt.executeUpdate("insert into test (name, roll) values ('prince', '30')");

                System.out.println(result);
                System.out.println("Querey excuted...");

            }catch(Exception e){
                System.out.println("Error in Save Data Exception"+e);
            }
        return true;
    }
   
}