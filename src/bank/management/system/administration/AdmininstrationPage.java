package bank.management.system.administration;
import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.accountRegistration.WelcomePage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class AdmininstrationPage extends JFrame implements ActionListener {
    JPanel mainPanel, adminPanel, showPanel;
    JLabel welcomeLabel,infoLabel, usernameLabel, fullNameLabel, mobileLabel, emailLabel, userTypeLabel, passwordLabel, cpasswordLabel, aadharCardLabel;
    JTextField usernameField, fullNameField, mobileField, emailField, userTypeField,passwordField, cpasswordField,aadharCardField;
    JButton createButton, clearButton, checkUsersButton,logoutButton, backButton;
    JComboBox roleTypeBox;
    
    AdmininstrationPage()
    {
        setResizable(false);
        setLayout(null);
        setSize(1000,500);
        setLocation(200,100);
        setTitle("Admin Panel");
        
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0,1000,500);
        add(mainPanel);  
        mainPanel.setLayout(null);  
        
        
        adminPanel = new JPanel();
        adminPanel.setBounds(250, 15,1000,500);
        add(adminPanel);  
        adminPanel.setLayout(null);   
       
        showPanel = new JPanel();
        showPanel.setBounds(0, 0,1000,500);
        add(showPanel);  
        showPanel.setBackground(Color.red);
        showPanel.setLayout(null);
        showPanel.setVisible(false);
        mainPanel.add(showPanel);
        mainPanel.add(adminPanel);
        
//        jName = new JLabel("Welcome \t Mr.");
//        jName.setBounds(10, 5, 550, 30);
//        jName.setFont(new Font("verdana", Font.BOLD, 13));
//        jpanel3.add(jName);
        
        infoLabel = new JLabel("Create New Users ||  Admins");        
        usernameLabel = new JLabel("UserName");
        usernameField = new JTextField();            
        fullNameLabel = new JLabel("Full Name");
        fullNameField = new JTextField();       
        
        mobileLabel = new JLabel("Mobile No");
        mobileField = new JTextField();        
        emailLabel= new JLabel("Email Id");
        emailField = new JTextField();
        
        userTypeLabel = new JLabel("Account Type");
        String s1[] = { "Select Role","Admin", "Manager","Staff"};
        roleTypeBox = new JComboBox(s1);
        
        passwordLabel = new JLabel("Password");
        passwordField = new JTextField();
        cpasswordLabel = new JLabel("Confirm Password");
        cpasswordField = new JTextField();
        
        aadharCardLabel = new JLabel("Aadhar Card");
        aadharCardField = new JTextField();
        
        clearButton = new JButton("CLEAR"); 
        clearButton.addActionListener(this);        
        createButton = new JButton("Create User");              
        createButton.addActionListener(this); 
        
        checkUsersButton = new JButton("Check Users");     
        checkUsersButton.addActionListener(this); 
        logoutButton = new JButton("LOGOUT");               
        logoutButton.addActionListener(this);
        backButton = new JButton("BACK");
        backButton.addActionListener(this);
        
        setFont();
        setBound();
        addComponent();          
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
    }
    // Constructor CLose Here...!!
    
    public void setFont(){
        
    }
    public void setBound(){
        infoLabel.setBounds(100, 25, 250, 50);
        usernameLabel.setBounds(20, 75, 150, 40);
        usernameField.setBounds(200, 75, 200, 40);
        fullNameLabel.setBounds(20, 120, 150, 40);
        fullNameField.setBounds(200, 120, 200, 40); 
        
        mobileLabel.setBounds(20, 165, 160, 40);
        mobileField.setBounds(200, 165, 200, 40);
        emailLabel.setBounds(20,210, 200, 40);
        emailField.setBounds(200, 210, 200, 40);
        userTypeLabel.setBounds(20, 255, 150, 40);
        roleTypeBox.setBounds(200, 255, 200, 30);
        passwordLabel.setBounds(20, 300, 150, 40);
        passwordField.setBounds(200, 300, 200, 40);
        cpasswordLabel.setBounds(20, 345, 180, 40);
        cpasswordField.setBounds(200, 345, 200, 40);
        aadharCardLabel.setBounds(410, 345, 50, 40);
        aadharCardField.setBounds(470, 345, 200, 40);
        clearButton.setBounds(20,405,80,30);
        createButton.setBounds(130,405,120,30);
        checkUsersButton.setBounds(280,405,120,30);
        logoutButton.setBounds(895,0,90,25);
        backButton.setBounds(890,435,90,25);  
    }
    public void addComponent(){
        adminPanel.add(infoLabel);               
        adminPanel.add(usernameLabel);
        adminPanel.add(usernameField);
        adminPanel.add(fullNameLabel);
        adminPanel.add(fullNameField);
        adminPanel.add(mobileLabel);
        adminPanel.add(mobileField);
        adminPanel.add(emailLabel);
        adminPanel.add(emailField);  
        adminPanel.add(userTypeLabel);
        adminPanel.add(roleTypeBox);
        adminPanel.add(passwordLabel);        
        adminPanel.add(passwordField);
        adminPanel.add(cpasswordLabel);
        adminPanel.add(cpasswordField);
        adminPanel.add(aadharCardLabel);
        adminPanel.add(aadharCardField);        
        adminPanel.add(clearButton);
        adminPanel.add(createButton);
        adminPanel.add(checkUsersButton);  
        mainPanel.add(logoutButton);
        showPanel.add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); 

    
       if("LOGOUT".equals(e.getActionCommand())){
        int response = JOptionPane.showConfirmDialog(this, "Do You Want to Logout ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            dispose();
            new WelcomePage();
        }
        
    }
       if("CLEAR".equals(e.getActionCommand())){
           userTypeField.setText("");   fullNameField.setText("");
           mobileField.setText("");     emailField.setText("");
           userTypeField.setText("");   passwordField.setText("");
           cpasswordField.setText("");
           
       }
       if("Create User".equals(e.getActionCommand())){
           
       }
       
       if("Check Users".equals(e.getActionCommand())){
          showPanel.setVisible(true);
          adminPanel.setVisible(false);
       }
       
       if("BACK".equals(e.getActionCommand())){
           showPanel.setVisible(false);
           adminPanel.setVisible(true);
           
       }          
    }
    
    
    public static void main(String[] args) {
        new AdmininstrationPage();
    }
    
}
