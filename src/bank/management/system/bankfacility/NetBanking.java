package bank.management.system.bankfacility;

import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.bankfacility.MobileBanking;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;



public class NetBanking extends JFrame implements ActionListener{

    JPanel mainPanel,optionPanel, facilityPanel;;
    JButton updateAddressButton, updateEmailIdButton, updateContactButton,backButton, clearButton, logoutButton; 
    static String applicantName="";
    
    private Connection connection; 
    private Statement statement;
    
    public NetBanking( String name) throws HeadlessException {
        this.applicantName = name;
        setTitle("NET BANKING WINDOW");
        setLayout(null);
        setResizable(false);
        setSize(950,600);
        setLocation(300,120);
        
         mainPanel = new JPanel(); 
        mainPanel.setBounds(0, 0,950,600);
        add(mainPanel);  
        mainPanel.setLayout(null);
               
        
        
        optionPanel= new JPanel(); 
        optionPanel.setBounds(750, 80,200,520);
        add(optionPanel);  
        optionPanel.setLayout(null);
        optionPanel.setBackground(Color.gray);
        
        facilityPanel= new JPanel(); 
        facilityPanel.setBounds(0, 80,750,520);
        add(facilityPanel);  
        facilityPanel.setLayout(null);
        facilityPanel.setBackground(Color.DARK_GRAY);

        updateAddressButton = new JButton("Update Address");
        updateAddressButton.addActionListener(this);
        updateEmailIdButton = new JButton("Update EmailID");
        updateEmailIdButton.addActionListener(this);
        updateContactButton = new JButton("Update Contact");
        updateContactButton.addActionListener(this);
        
        backButton = new JButton("BACK");
        backButton.addActionListener(this);
        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);             
        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(this);       
        
        setFont();
        setBound();
        addComponent();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);    
    }
    
    public void setFont(){
        updateEmailIdButton.setFont(new Font("verdana", Font.BOLD, 13));
        updateAddressButton.setFont(new Font("verdana", Font.BOLD, 13));
        updateContactButton.setFont(new Font("verdana", Font.BOLD, 13));
        backButton.setFont(new Font("verdana", Font.BOLD, 15));
        clearButton.setFont(new Font("verdana", Font.BOLD, 15));
        logoutButton.setFont(new Font("verdana", Font.BOLD, 16));
    }
    public void setBound(){
         logoutButton.setBounds(800,3,140,40);
    }
    public void addComponent(){
         mainPanel.add(optionPanel);
         mainPanel.add(facilityPanel);
         mainPanel.add(logoutButton);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if("LOGOUT".equals(event.getActionCommand())){
        int response = JOptionPane.showConfirmDialog(this, "Do You Want to Logout ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            dispose();
            new ChooseFacility(applicantName);
        }
    }
  }
    
    
    
    public static void main(String[] args) {
        new NetBanking(applicantName);
    }
}
