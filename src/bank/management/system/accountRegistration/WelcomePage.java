package bank.management.system.accountRegistration;

import bank.management.system.bankfacility.ChoseFacility;
import bank.management.system.database.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WelcomePage extends JFrame implements ActionListener {
    
    JPanel panelImage, panelContent;
    JLabel imageLabel, messgaeLabel,usernameLabel,passwordLabel, emailOtpLabel;
    JTextField usernameField,passwordField, emailOtpField;
    JButton registerButton,loginButton,forgetpassowrdButton, verifyDetails;
    private Connection connection;
    private Statement statement;
    
    public WelcomePage(){
        
        setLayout(null);
        setResizable(false);
        setSize(920,500);
        setLocation(200,100);
        setTitle("HOME PAGE"); 
        
        panelImage = new JPanel();       
        add(panelImage); 
        panelImage.setLayout(null);        
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img1 = img.getImage().getScaledInstance(350, 500, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        imageLabel = new JLabel(img2);
        imageLabel.setBounds(0, 0, 350, 500);
        panelImage.add(imageLabel);       
        
        panelContent = new JPanel();
        add(panelContent);
        panelContent.setLayout(null);
        
        
        messgaeLabel = new JLabel("Welcome To CEGians Bank");
        usernameLabel = new JLabel("Username");
        usernameField = new JTextField();

        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();        
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
        usernameField.setFont(new Font("verdana", Font.ITALIC, 16));
        passwordLabel.setFont(new Font("verdana", Font.BOLD, 14));
        passwordField.setFont(new Font("verdana", Font.BOLD, 16));
    }
    public void setBound(){  
        panelImage.setBounds(0, 0,350,500);
        panelContent.setBounds(355, 0,500,500);      
        messgaeLabel.setBounds(50,50,450,40);     
        usernameLabel.setBounds(40,150,100,50);        
        usernameField.setBounds(150, 150, 250, 40);
        passwordLabel.setBounds(40, 225,250,20);
       
        passwordField.setBounds(150, 220, 250, 40);
        loginButton.setBounds(150,300,100,35);      
        registerButton.setBounds(300,300,100,35); 
        forgetpassowrdButton.setBounds(210,360,150,35);
    }
    public void addComponent(){
        panelContent.add(messgaeLabel);     panelContent.add(usernameLabel);
        panelContent.add(usernameField);    panelContent.add(passwordLabel);
        panelContent.add(passwordField);    panelContent.add(loginButton);
        panelContent.add(registerButton);   panelContent.add(forgetpassowrdButton);      
    }
        
    
   public static void main(String [] args){   
       new WelcomePage();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
       if("Forget password".equals(e.getActionCommand()))
       {
           dispose();
           new InformationRecovery();          
       }
        if("Register".equals(e.getActionCommand()))
       {
           dispose();
           new AccountRegisteration();
       }       
        
       if("Sign In".equals(e.getActionCommand()))
       {
          if(usernameField.getText().trim().isEmpty() && passwordField.getText().trim().isEmpty()){
                   usernameField.setFocusable(true);
                   JOptionPane.showMessageDialog(null, "Login Credential cannot be empty !! \n\n");
                   loginButton.setForeground(Color.RED);
               } 
          else if (usernameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()){
                   JOptionPane.showMessageDialog(null, "UserName or Password cannot be empty: \n\n");
                   usernameField.setText("");
                   passwordField.setText("");
               }
           try{
               connection = DatabaseConnection.ConnectionString();
               statement  = connection.createStatement();
               ResultSet resultSet = statement.executeQuery("select username, password from user_details where username='"+usernameField.getText().trim()+"'and password='"+passwordField.getText().trim()+"'");
                if(resultSet.next()){
                        JOptionPane.showMessageDialog(this, "User already exists !!");
                    }
                else{
                    // redirect to AccountRegistration-Page1 and dispose it
                }
           }catch(HeadlessException | ClassNotFoundException | SQLException exception){
               System.out.println("Exception is:"+"\n"+exception);
           }
           finally{
              try {
                  statement.close();
                  connection.close();
              } catch (SQLException ex) {
                  Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, ex);
              }
             
           }
               
       }
    } // Action-Performed Method close here:
    
    
}// Login Class End Here:

// Login BUtton Work Models:
/*
1. Check Whether USername || password any one || both are blank 
2. If username hold ADMIN/MANAGER/STAFF then => "EMAIL-OTP-VERIFICATION" => redirect ROLE-BASED-PAGE
3. IF username hold registered Account-Person then redirect Banking-Facilities: ( with username|| Name on the page)
4. If Given-value is not registerd then SHOW ERROR MESSAGE => Not Registered in our Server then ==> Redirect directly AccountRegistration --Page:






*/