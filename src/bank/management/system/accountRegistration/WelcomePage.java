package bank.management.system.accountRegistration;

import bank.management.system.administration.ManagerPage;
import bank.management.system.administration.StaffPage;
import bank.management.system.bankfacility.ChooseFacility;
import bank.management.system.database.DatabaseConnection;
import bank.management.system.database.EmailOtpVerification;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WelcomePage extends JFrame implements ActionListener {
    JPanel panelImage, panelContent, emailOtpPanel;
    JLabel imageLabel, messgaeLabel, usernameLabel, passwordLabel, loginTypeLabel, emailOtpLabel;
    static JTextField usernameField, passwordField, loginTypeField, emailOtpField;
    JButton registerButton, signInButton, forgetpassowrdButton, verifyEmailButton;
    
    public static String currentUserId = "";
    long startTime = System.currentTimeMillis(), elapsedTime = 0L;
    public static String currentUserName = "";
    public String OTP = EmailOtpVerification.generateOTPForEmailVerification().toString();
    public int state= -1;
    
    private  Connection connection;
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
        
        emailOtpPanel = new JPanel();
        add(emailOtpPanel);
        emailOtpPanel.setLayout(null);
        emailOtpPanel.setVisible(false);
        
        
        messgaeLabel = new JLabel("Welcome To CEGians Bank");
        usernameLabel = new JLabel("Username");
        usernameField = new JTextField();

        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();   
        loginTypeLabel = new JLabel("Login Type");
        loginTypeField = new JTextField();
        loginTypeField.setEditable(false);
        emailOtpLabel = new JLabel("Email OTP:");
        emailOtpField = new JTextField();
        
        signInButton = new JButton("Sign In");
        signInButton.addActionListener(this);        
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        
        forgetpassowrdButton = new JButton("Forget password");
        forgetpassowrdButton.addActionListener(this);
        verifyEmailButton = new JButton("Verify OTP");
        verifyEmailButton.addActionListener(this);
                
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
        emailOtpPanel.setBounds(0, 350,500,130); 
        
        messgaeLabel.setBounds(50,50,450,40);     
        usernameLabel.setBounds(40,150,100,50);        
        usernameField.setBounds(150, 150, 250, 40);
        passwordLabel.setBounds(40, 225,250,20);       
        passwordField.setBounds(150, 220, 250, 40);
        signInButton.setBounds(150,300,100,35);      
        registerButton.setBounds(300,300,100,35); 
        forgetpassowrdButton.setBounds(210,360,150,35);
        
        loginTypeLabel.setBounds(10, 350,50,20); 
        loginTypeField.setBounds(70, 350,200,30);
        emailOtpLabel.setBounds(10, 380,50,20);
        emailOtpField.setBounds(70, 380,200,30);
        verifyEmailButton.setBounds(300, 380,100,30);
    }
    public void addComponent(){
        panelContent.add(emailOtpPanel);
        panelContent.add(messgaeLabel); 
        panelContent.add(usernameLabel);
        panelContent.add(usernameField); 
        panelContent.add(passwordLabel);
        panelContent.add(passwordField);  
        panelContent.add(signInButton);
        panelContent.add(registerButton); 
        panelContent.add(forgetpassowrdButton);  
        
        emailOtpPanel.add(loginTypeLabel);
        emailOtpPanel.add(loginTypeField);
        emailOtpPanel.add(emailOtpLabel);
        emailOtpPanel.add(emailOtpField);
        emailOtpPanel.add(verifyEmailButton);
    }
        
     
   public static void main(String [] args){   
       new WelcomePage();
   }

    @Override
    public void actionPerformed(ActionEvent event) {
       if("Forget password".equals(event.getActionCommand()))
       {
           dispose();
           new InformationRecovery();          
       }
        if("Register".equals(event.getActionCommand()))
       {
           dispose();
           new AccountRegisteration();
       }       
        
       if("Sign In".equals(event.getActionCommand()))
       {
          if(usernameField.getText().trim().isEmpty() && passwordField.getText().trim().isEmpty()){
                   usernameField.setFocusable(true);
                   JOptionPane.showMessageDialog(null, "Login Credential cannot be empty !! \n\n");
                   signInButton.setForeground(Color.RED);
               } 
          else if (usernameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()){
                   JOptionPane.showMessageDialog(null, "UserName or Password cannot be empty: \n\n");
                   usernameField.setText("");
                   passwordField.setText("");
               }
          else{
              try{
                connection = DatabaseConnection.ConnectionString();
                statement  = connection.createStatement();
                
                ResultSet resultSet = statement.executeQuery("select login_type from user_details where username='"+usernameField.getText().trim()+"'"
                                      + " AND password='"+passwordField.getText().trim()+"'");
                  if(resultSet.next()){
                     String loginType = resultSet.getString("login_type");
                      if("Admin".equals(loginType)){
                        emailOtpPanel.setVisible(true);
                        
                        state = 1;
                        System.err.println("Your Login OTP is: \t"+OTP);
                        EmailOtpVerification.sendEmail(OTP, resultSet.getString("name"),
                                resultSet.getString("username"), resultSet.getString("email_id"));
                        currentUserId = usernameField.getText().trim();
                        currentUserName = resultSet.getString("name");
                     
                                      
                }else if("Manager".equals(loginType) ){
                        emailOtpPanel.setVisible(true);
                    new ManagerPage();
                }
                else if("Staff".equals(loginType)){
                        emailOtpPanel.setVisible(true);
                    new StaffPage();
                }
                
                else if("customer".equals(loginType)){
                        dispose();
                        new ChooseFacility();
                   }
                 }
                        JOptionPane.showMessageDialog(this, "Invalid username or password");
                        usernameField.setText("");
                        passwordField.setText("");
            }catch(HeadlessException | ClassNotFoundException | SQLException exception){              
                  Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, exception);
              } finally{
              try {
                  statement.close();
                  connection.close();   
              } catch (SQLException ex) {
                  Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, ex);
              }               
            } 
          }     
       }
    }
}


// Login BUtton Work Models:
/*
1. Check Whether USername || password any one || both are blank 
2. If username hold ADMIN/MANAGER/STAFF then => "EMAIL-OTP-VERIFICATION" => redirect ROLE-BASED-PAGE
3. IF username hold registered Account-Person then redirect Banking-Facilities: ( with username|| Name on the page)
4. If Given-value is not registerd then SHOW ERROR MESSAGE => Not Registered in our Server then ==> Redirect directly AccountRegistration --Page:






*/