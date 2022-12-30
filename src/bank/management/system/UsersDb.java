/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.util.ArrayList;

/**
 *
 * @author princ
 */
public class UsersDb {
    private static ArrayList<Users> us = null;

    public ArrayList<Users> getUs() {
        return us;
    }

    public void setUs(ArrayList<Users> us) {
        this.us = us;
    }
    public UsersDb(){
        us = getInstance();
    } 
    
    public static ArrayList getInstance()
    {
        if (us == null)
            us = new ArrayList();
  
        return us;
    }
    
    
}
