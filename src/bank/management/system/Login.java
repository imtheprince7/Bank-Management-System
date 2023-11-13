package bank.management.system;

import bank.management.system.database.DatabaseConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class Login extends JFrame implements ActionListener {
    HashMap<String, String> users = new HashMap<>();
    
    JPanel panelImage, panelContent;
    JLabel imageLabel, messgaeLabel,usernameLabel,passwordLabel;
    JTextField usernameFiled,messageField;
    JPasswordField passwordFiled;
    JButton registerButton,loginButton,forgetpassowrdButton;
   
    Login(HashMap<String,String> userDetails){
       users = userDetails;
       System.out.println(users+" ");
    }
    Login(){
        
        setLayout(null);
        setResizable(false);
        setSize(920,500);
        setLocation(200,100);
        setTitle("HOME PAGE"); 
        
        panelImage = new JPanel();
        panelImage.setBounds(0, 0,350,500);
        add(panelImage); 
        panelImage.setLayout(null);        
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img1 = img.getImage().getScaledInstance(350, 500, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        imageLabel = new JLabel(img2);
        imageLabel.setBounds(0, 0, 350, 500);
        panelImage.add(imageLabel);       
        
        panelContent = new JPanel();
        panelContent.setBounds(355, 0,500,500);
        add(panelContent);
        panelContent.setLayout(null);
        
        
        messgaeLabel = new JLabel("Welcome To CEGians Bank");
        usernameLabel = new JLabel("Username");
        usernameFiled = new JTextField();

        // Error message if occur during login
        messageField = new JTextField();
        messageField.setEditable(false);
        messageField.setVisible(false);

        passwordLabel = new JLabel("Password");
        passwordFiled = new JPasswordField();
        
        loginButton = new JButton("Sign In");
        loginButton.addActionListener(this);        
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        forgetpassowrdButton = new JButton("Forget password");
        forgetpassowrdButton.addActionListener(this);
                
        setFont();
        setBound();
        addComponent();
        
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
    }
    
    public void setFont(){
        messgaeLabel.setFont(new Font("verdana", Font.BOLD, 28));        
        usernameLabel.setFont(new Font("verdana", Font.BOLD, 14));
        usernameFiled.setFont(new Font("verdana", Font.ITALIC, 14));
        messageField.setFont(new Font("verdana", Font.ITALIC, 12));
        messageField.getSelectedTextColor().getRed();
        passwordLabel.setFont(new Font("verdana", Font.BOLD, 14));
        passwordFiled.setFont(new Font("verdana", Font.BOLD, 14));
    }
    public void setBound(){        
        messgaeLabel.setBounds(50,50,450,40);     
        usernameLabel.setBounds(40,150,100,50);        
        usernameFiled.setBounds(150, 150, 250, 40);
        passwordLabel.setBounds(40, 225,250,20);
        messageField.setBounds(350, 190,200,25);

        passwordFiled.setBounds(150, 220, 250, 40);
        loginButton.setBounds(150,300,100,35);      
        registerButton.setBounds(300,300,100,35); 
        forgetpassowrdButton.setBounds(210,360,150,35);
    }
    public void addComponent(){
        panelContent.add(messgaeLabel);     panelContent.add(usernameLabel);
        panelContent.add(usernameFiled);    panelContent.add(passwordLabel);
        panelContent.add(passwordFiled);    panelContent.add(loginButton);
        panelContent.add(registerButton);   panelContent.add(forgetpassowrdButton);
        panelContent.add(messageField);
    }
        
    
   public static void main(String [] args)
   {   
       new Login();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
       if("Forget password".equals(e.getActionCommand()))
       {
           dispose();
           new InfoRecovery();          
       }
        if("Register".equals(e.getActionCommand()))
       {
           dispose();
           new Register();          
       }       
        
       if("Sign In".equals(e.getActionCommand()))
       {
           try{
               // calling COnnection from the database-package:
              Connection connection = DatabaseConnection.ConnectionString();
               
           
           if(usernameFiled.getText().trim().isEmpty() && passwordFiled.getText().trim().isEmpty()){
                   messageField.setText("Field(s) are Empty:");
                   usernameFiled.setFocusable(true);
                   JOptionPane.showMessageDialog(null, "Username is empty !");
                   loginButton.setForeground(Color.RED);
               } 
           else if (usernameFiled.getText().trim().isEmpty()){
                   messageField.setVisible(true);
                   messageField.setText("UserName is Empty:");
               }               
           else{
                   dispose();
                   new Register();          
               }
           
           } // try-block end here:
           catch(HeadlessException | ClassNotFoundException | SQLException exception){
               System.out.println("Exception is:"+"\n"+exception);
           }// try-catch-block end here:
           
       } //Sign-In Action-Performed Method   close Here:
    } // Action-Performed Method close here:
    
    
}// Login Class End Here: