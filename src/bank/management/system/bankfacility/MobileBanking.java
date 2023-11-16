package bank.management.system.bankfacility;

import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.database.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class MobileBanking extends JFrame implements ActionListener{
    JPanel mainPanel, facilityMesagepanel, facilityButtonPanel;
    JLabel nameLabel;
    JTextField nameField;
    JButton depositButton, fastCashButton, pinChangeButton,cashWithdrawalButton, miniStatementButton, exitButton,logoutButton;
// Creating connection and Statement globally:
     private Connection connection;
     private  Statement statement;
    
    public MobileBanking() throws HeadlessException {
        setTitle("Common Banking Facilities");
        setLayout(null);
        setResizable(false);
        setSize(700,500);
        setLocation(350,150);
        
        mainPanel= new JPanel(); 
        add(mainPanel);  
        mainPanel.setLayout(null);
        
        facilityButtonPanel = new JPanel();
        add(facilityButtonPanel);
        facilityButtonPanel.setBackground(Color.red);
        facilityButtonPanel.setLayout(null);
        facilityButtonPanel.setVisible(true);
        
        facilityMesagepanel = new JPanel();
        add(facilityMesagepanel);
        facilityMesagepanel.setBackground(Color.CYAN);
        facilityMesagepanel.setLayout(null);
        facilityMesagepanel.setVisible(true);
        
        nameLabel = new JLabel("Hello");
        nameField = new JTextField();
        nameField.setEditable(false);
        
        
                


        depositButton = new JButton("DEPOSIT");
        depositButton.addActionListener(this);
        fastCashButton = new JButton("FAST CASH");
        fastCashButton.addActionListener(this);
        
        pinChangeButton = new JButton("PIN CHANGE");
        pinChangeButton.addActionListener(this);
        cashWithdrawalButton = new JButton("CASH WITHDRAWAL");
        cashWithdrawalButton.addActionListener(this);
        
        miniStatementButton = new JButton("MINI STATEMENT");
        miniStatementButton.addActionListener(this);
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);
        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(this);
        
        
        addComponent();
        setBound();
        setFont();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);    
    }
    
     public void addComponent(){
        mainPanel.add(logoutButton);
        mainPanel.add(facilityButtonPanel);
        mainPanel.add(facilityMesagepanel);
        mainPanel.add(facilityMesagepanel.add(nameLabel));
        mainPanel.add(facilityMesagepanel.add(nameField));
        mainPanel.add(facilityButtonPanel.add(depositButton));
        mainPanel.add(facilityButtonPanel.add (fastCashButton));
        mainPanel.add(facilityButtonPanel.add(pinChangeButton));
        mainPanel.add(facilityButtonPanel.add(cashWithdrawalButton));
        mainPanel.add(facilityButtonPanel.add(miniStatementButton));
        mainPanel.add(facilityButtonPanel.add(exitButton));
    }
    public void setFont(){
        nameLabel.setFont(new Font("verdana", Font.BOLD, 28));  
    }
    public void setBound(){
        mainPanel.setBounds(0, 0,700,500);
        facilityMesagepanel.setBounds(0, 100, 500, 400);
        facilityButtonPanel.setBounds(500, 100, 200, 400);
        nameLabel.setBounds(5, 100, 100, 25);
        nameField.setBounds(120, 100, 250, 25);
        
        
        depositButton.setBounds(520,150,150,40);
        fastCashButton.setBounds(520,200,150,40);
        pinChangeButton.setBounds(520,250,150,40);
        cashWithdrawalButton.setBounds(520,300,150,40);
        miniStatementButton.setBounds(520,350,150,40);
        exitButton.setBounds(510,410,170,40);       
        logoutButton.setBounds(590,3,90,30);
    }    
    
    public static void main(String[] args) {
        new MobileBanking();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if("LOGOUT".equals(event.getActionCommand())){
        int response = JOptionPane.showConfirmDialog(this, "Do You Want to LOGOUT ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            dispose();
            new WelcomePage();
        }
     }
      
    if("DEPOSIT".equals(event.getActionCommand())){
            try{
                connection = DatabaseConnection.ConnectionString();
                
                
                
            } catch (ClassNotFoundException | SQLException exception) {
                Logger.getLogger(MobileBanking.class.getName()).log(Level.SEVERE, null, exception);
            } 
     
    }
      
    if("FAST CASH".equals(event.getActionCommand())){
     
    }
      
    if("PIN CHANGE".equals(event.getActionCommand())){
     
    }
      
    if("CASH WITHDRAWAL".equals(event.getActionCommand())){
     
    }
    
    if("MINI STATEMENT".equals(event.getActionCommand())){
     
    }    
    
    if("EXIT".equals(event.getActionCommand())){
      int response = JOptionPane.showConfirmDialog(this, "Do You Want to EXIT ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
      if(response==JOptionPane.YES_OPTION){
          dispose();
          new WelcomePage();
        }     
      }
    }
    
    
    
    
    
    
  
 // getting Name of logged in userName:
   
  
}




    
    
    
    
    
 