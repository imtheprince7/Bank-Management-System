package bank.management.system.administration;

import bank.management.system.accountRegistration.WelcomePage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StaffPage extends JFrame implements ActionListener {

    JPanel mainPanel;
    JButton logoutButton;
    // Creating connection and Statement globally:
    private Connection connection;
    private Statement statement;
    static String applicantName = "";

    public StaffPage(String name) {
        this.applicantName = name;
        
        setResizable(false);
        setLayout(null);
        setSize(900, 600);
        setLocation(250, 150);
        setTitle("Staffs Panel");
        
        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(null);
        
        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(this);
        
        addComponent();
        setBound();
        setFont();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
    }

    public void addComponent() {
        mainPanel.add(logoutButton);
        
    }
    
    public void setFont() {
        logoutButton.setFont(new Font("verdana", Font.BOLD, 15));
    }
    
    public void setBound() {
        logoutButton.setBounds(650, 5, 130, 40);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
         if ("LOGOUT".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to LOGOUT ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new WelcomePage();
            }
        }
    }
    
}
