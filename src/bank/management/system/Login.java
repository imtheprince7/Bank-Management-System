package bank.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author princ
 */
public class Login extends JFrame implements ActionListener {
    JButton jregister,jlogin,jfpassword;
    JLabel jImagelabel, jtext,juname,jpswd;
    JTextField jufiled,jpfilled;
    String name;
    
    Login(){
        setLayout(null);
    // Disable Maximize Click
        setResizable(false);
        setSize(900,500);
        setLocation(300,150);
        
        
        setTitle("Home");
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
        Image img1 = img.getImage().getScaledInstance(250, 500, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        
        jImagelabel = new JLabel(img2);
        jImagelabel.setBounds(0, 0, 250, 500);
        add(jImagelabel);
        
        
    // Welcome Text
        jtext = new JLabel("Welcome TO CEGians Bank");
        jtext.setFont(new Font("verdana", Font.BOLD, 28));
        jtext.setBounds(350,40,450,40);
        add(jtext);
    //userName Text & textField
        juname = new JLabel("Username");
        juname.setFont(new Font("verdana", Font.BOLD, 14));
        juname.setBounds(350,120,100,50);
        add(juname);
        jufiled = new JTextField();
        jufiled.setBounds(500, 125, 250, 40);
        jufiled.setFont(new Font("verdana", Font.ITALIC, 14));
        add(jufiled);
        name = jufiled.getText();
        
        
    //password Text & textField
        jpswd = new JLabel("Password");
        jpswd.setFont(new Font("verdana", Font.BOLD, 14));
        jpswd.setBounds(350,200,250,20);
        add(jpswd);
        jpfilled = new JTextField();
        jpfilled.setBounds(500, 190, 250, 40);
        jpfilled.setFont(new Font("verdana", Font.BOLD, 14));
        add(jpfilled);
     
    //SignIn Button
        jlogin = new JButton("Sign In");
        jlogin.setBounds(500,255,100,30);
        jlogin.addActionListener(this);
        add(jlogin);
      
      //Register Button
        jregister = new JButton("Register");
        jregister.setBounds(650,255,100,30);
        jregister.addActionListener(this);
        add(jregister);
        
        
    //ForgetPassword Button
        jfpassword = new JButton("Forget password");
        jfpassword.setBounds(550,310,150,30);
        jfpassword.addActionListener(this);
        add(jfpassword);
        
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
    }
    
   public static void main(String [] args){
     //  Conn con = new Conn();
      new Login();      
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       if(e.getActionCommand()== "Forget password")
       {
           dispose();
           new ForgetPassword();          
       }
        if(e.getActionCommand()== "Register")
       {
           dispose();
           new Register();          
       }
        
        
         if(e.getActionCommand()== "Sign In")
       {
           if(jufiled.getText().equals("admin") && jpfilled.getText().equals("admin"))
           {
               // Genreating Multiple Message on POP-UP
            JOptionPane.showMessageDialog(null,"userType:"+" "+jufiled.getText()+"\n"+" Password:"+" "+jpfilled.getText()+" ");
              dispose();
              new AdminPanel(name);
           }
           else
           {
               dispose();
               new Register();
           }
          
          
       }
              
    }
}