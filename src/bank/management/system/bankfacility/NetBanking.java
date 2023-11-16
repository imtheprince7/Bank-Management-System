package bank.management.system.bankfacility;

import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.bankfacility.MobileBanking;
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

    JPanel mainPanel;
    JButton createButton, clearButton, checkUsersButton,logoutButton, backButton;
    
    private Connection connection;  
    private Statement statement;
    
    public NetBanking() throws HeadlessException {
        setTitle("Net Banking Facility");
        setLayout(null);
        setResizable(false);
        setSize(950,600);
        setLocation(300,120);
        
        mainPanel= new JPanel(); 
        mainPanel.setBounds(0, 0,950,600);
        add(mainPanel);  
        mainPanel.setLayout(null);



        
        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(this);
        
        
        setFont();
        setBound();
        addComponent();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);    
    }
    
    public void setFont(){
        
    }
    public void setBound(){
         logoutButton.setBounds(840,3,90,30);
    }
    public void addComponent(){
         mainPanel.add(logoutButton);
    }
    
    
    public static void main(String[] args) {
        new MobileBanking();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if("LOGOUT".equals(event.getActionCommand())){
        int response = JOptionPane.showConfirmDialog(this, "Do You Want to Logout ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            dispose();
            new WelcomePage();
        }
    }
  
  } 
}
