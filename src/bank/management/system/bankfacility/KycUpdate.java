package bank.management.system.bankfacility;

import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.database.DatabaseConnection;
import static bank.management.system.database.MysqlJoinsClasses.getAccountDetails;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KycUpdate extends JFrame implements ActionListener {

    JPanel mainPanel, optionPanel, facilityPanel, commonPanel, addressPanel, emailPanel, contactPanel;

    JLabel accountyNameLabel,accountNumberLabel,userNameLabel, addressLineOneLabel,addressLineTwoLabel,pincodeLabel,cityLabel,
            stateLabel, oldEmailIdLabel, emailIdLabel, oldContactLabel, contactLabel;
    JTextField accountyNameField, accountNumberField, userNameField, addressLineOneField,addressLineTwoField,pincodeField,cityField,
            stateField, oldEmailIdField, emailIdField, oldContactField, contactField;
    JButton updateAddressButton, updateEmailIdButton, updateContactButton, backButton, clearButton, updateNewAddressButton, updateEmailIDButton,
            updateContactNoButton, logoutButton;
    static String applicantName = "", accountyName, accountNumber;

     private Connection connection = DatabaseConnection.ConnectionString();
     private Statement statement;

    public KycUpdate(String name) throws HeadlessException, ClassNotFoundException, SQLException {
        this.applicantName = name;
        setTitle("KYC UPDATE WINDOW");
        setLayout(null);
        setResizable(false);
        setSize(950, 600);
        setLocation(300, 120);
        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(null);

        optionPanel = new JPanel();
        add(optionPanel);
        optionPanel.setLayout(null);
        optionPanel.setBackground(Color.gray);
        updateAddressButton = new JButton("Update Address");
        updateAddressButton.addActionListener(this);
        updateEmailIdButton = new JButton("Update EmailID");
        updateEmailIdButton.addActionListener(this);
        updateContactButton = new JButton("Update Contact");
        updateContactButton.addActionListener(this);
        backButton = new JButton("BACK");
        backButton.addActionListener(this);

        facilityPanel = new JPanel();
        add(facilityPanel);
        facilityPanel.setLayout(null);
        facilityPanel.setBackground(Color.DARK_GRAY);
        
        commonPanel = new JPanel();
        add(commonPanel);
        commonPanel.setLayout(null);
        commonPanel.setBackground(Color.lightGray);
        
        accountyNameLabel = new JLabel("Name");
        accountyNameField = new JTextField();
        accountyNameField.setEditable(false);
        accountyNameField.setText(getAccountDetails().get(0));
        
        userNameLabel = new JLabel("Name");
        userNameField = new JTextField();
        userNameField.setEditable(false);
        userNameField.setText(getAccountDetails().get(3));
        
        accountNumberLabel = new JLabel("Account Number");
        accountNumberField = new JTextField();
        accountNumberField.setEditable(false);
        accountNumberField.setText(getAccountDetails().get(1));
        
        
        addressPanel = new JPanel();
        add(addressPanel);
        addressPanel.setLayout(null);
        addressPanel.setBackground(Color.DARK_GRAY);
        addressPanel.setVisible(false);
        addressLineOneLabel = new JLabel("Address Line 1");
        addressLineOneField = new JTextField(70);
        addressLineTwoLabel = new JLabel("Address Line 2");
        addressLineTwoField = new JTextField(70);
        pincodeLabel = new JLabel("PinCode");
        pincodeField = new JTextField();
        cityLabel = new JLabel("City");
        cityField = new JTextField();
        stateLabel = new JLabel("State");
        stateField = new JTextField();
        
        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);
        clearButton.setVisible(false);
        updateNewAddressButton = new JButton("UPDATE ADDRESS");
        updateNewAddressButton.addActionListener(this);
        
        
        emailPanel = new JPanel();
        add(emailPanel);
        emailPanel.setLayout(null);
        emailPanel.setBackground(Color.DARK_GRAY);
        emailPanel.setVisible(false);
        oldEmailIdLabel = new JLabel("Old Email ID");
        oldEmailIdField = new JTextField();
        oldEmailIdField.setEditable(false);
        oldEmailIdField.setText(getAccountDetails().get(4));
        emailIdLabel = new JLabel("Email ID");
        emailIdField = new JTextField();
        updateEmailIDButton= new JButton("Update EmailID");
        updateEmailIDButton.addActionListener(this);
                
        contactPanel = new JPanel();
        add(contactPanel);
        contactPanel.setLayout(null);
        contactPanel.setBackground(Color.DARK_GRAY);
        contactPanel.setVisible(false);
        oldContactLabel = new JLabel("Old Contact");
        oldContactField = new JTextField();
        oldContactField.setEditable(false);
        oldContactField.setText(getAccountDetails().get(5));        
        contactLabel = new JLabel("New Contact");
        contactField = new JTextField();
        updateContactNoButton= new JButton("Update Contact");
        updateContactNoButton.addActionListener(this);
        
        
        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(this);

        setFont();
        setBound();
        addComponent();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setFont() {
        updateEmailIdButton.setFont(new Font("verdana", Font.BOLD, 13));
        updateAddressButton.setFont(new Font("verdana", Font.BOLD, 13));
        updateContactButton.setFont(new Font("verdana", Font.BOLD, 13));
        backButton.setFont(new Font("verdana", Font.BOLD, 15));
        clearButton.setFont(new Font("verdana", Font.BOLD, 15));
        accountyNameLabel.setFont(new Font("verdana", Font.BOLD, 15));
        accountyNameField.setFont(new Font("verdana", Font.BOLD, 15));
        userNameLabel.setFont(new Font("verdana", Font.BOLD, 15));
        userNameField.setFont(new Font("verdana", Font.BOLD, 15));
        accountNumberLabel.setFont(new Font("verdana", Font.BOLD, 15));
        accountNumberField.setFont(new Font("verdana", Font.BOLD, 15));
        addressLineOneLabel.setFont(new Font("verdana", Font.BOLD, 15));
        addressLineOneField.setFont(new Font("verdana", Font.BOLD, 15));
        addressLineTwoLabel.setFont(new Font("verdana", Font.BOLD, 15));
        addressLineTwoField.setFont(new Font("verdana", Font.BOLD, 15));
        pincodeLabel.setFont(new Font("verdana", Font.BOLD, 15));
        pincodeField.setFont(new Font("verdana", Font.BOLD, 15));
        cityLabel.setFont(new Font("verdana", Font.BOLD, 15));
        cityField.setFont(new Font("verdana", Font.BOLD, 15));
        stateLabel.setFont(new Font("verdana", Font.BOLD, 15));
        stateField.setFont(new Font("verdana", Font.BOLD, 15));
        oldEmailIdLabel.setFont(new Font("verdana", Font.BOLD, 15));
        oldEmailIdField.setFont(new Font("verdana", Font.BOLD, 15));
        emailIdLabel.setFont(new Font("verdana", Font.BOLD, 15));
        emailIdField.setFont(new Font("verdana", Font.BOLD, 15));
        oldContactLabel.setFont(new Font("verdana", Font.BOLD, 15));
        oldContactField.setFont(new Font("verdana", Font.BOLD, 15));
        contactLabel.setFont(new Font("verdana", Font.BOLD, 15));
        contactField.setFont(new Font("verdana", Font.BOLD, 15));
        updateNewAddressButton.setFont(new Font("verdana", Font.BOLD, 14));
        updateEmailIDButton.setFont(new Font("verdana", Font.BOLD, 14));
        updateContactNoButton.setFont(new Font("verdana", Font.BOLD, 14));
        logoutButton.setFont(new Font("verdana", Font.BOLD, 16));
    }

    public void setBound() {
        mainPanel.setBounds(0, 0, 950, 600);
        optionPanel.setBounds(750, 80, 200, 520);
        updateAddressButton.setBounds(760, 150, 150, 50);
        updateEmailIdButton.setBounds(760, 250, 150, 50);
        updateContactButton.setBounds(760, 350, 150, 50);
        backButton.setBounds(760, 450, 150, 45);

        facilityPanel.setBounds(0, 80, 750, 520);
        commonPanel.setBounds(0, 0, 750, 160);
        accountyNameLabel.setBounds(10, 10, 150, 40);
        accountyNameField.setBounds(230, 10, 250, 40);
        userNameLabel.setBounds(10, 60, 150, 40);
        userNameField.setBounds(230, 60, 250, 40);
        accountNumberLabel.setBounds(10,100, 150, 40);
        accountNumberField.setBounds(230, 110, 250, 40);
        
        addressPanel.setBounds(0, 160, 750, 440);
        
        
        emailPanel.setBounds(0, 160, 750, 440);
        oldEmailIdLabel.setBounds(10, 50, 150, 40);
        oldEmailIdField.setBounds(230, 50, 250, 40);
        emailIdLabel.setBounds(10, 130, 150, 40);
        emailIdField.setBounds(230, 130, 250, 40);
        updateEmailIDButton.setBounds(510, 250, 180, 40);
        
        
        contactPanel.setBounds(0, 160, 750, 440);
        oldContactLabel.setBounds(10, 50, 150, 40);
        oldContactField.setBounds(230, 50, 250, 40);
        contactLabel.setBounds(10, 130, 150, 40);
        contactField.setBounds(230, 130, 250, 40);
        updateContactNoButton.setBounds(510, 250, 180, 40);
        
        logoutButton.setBounds(800, 3, 140, 40);
    }

    public void addComponent() {
        mainPanel.add(optionPanel);
        mainPanel.add(optionPanel.add(updateAddressButton));
        mainPanel.add(optionPanel.add(updateEmailIdButton));
        mainPanel.add(optionPanel.add(updateContactButton));
        mainPanel.add(optionPanel.add(backButton));
        mainPanel.add(facilityPanel);
        facilityPanel.add(commonPanel);
        
        commonPanel.add(accountyNameLabel);
        commonPanel.add(accountyNameField);
        commonPanel.add(accountNumberLabel);
        commonPanel.add(accountNumberField);
        commonPanel.add(userNameLabel);
        commonPanel.add(userNameField);
        
        facilityPanel.add(addressPanel);
        addressPanel.add(addressLineOneLabel);
        addressPanel.add(addressLineOneField);
        addressPanel.add(addressLineTwoLabel);
        addressPanel.add(addressLineTwoField);
        addressPanel.add(pincodeLabel);
        addressPanel.add(pincodeField);
        addressPanel.add(cityLabel);
        addressPanel.add(cityField);
        addressPanel.add(stateLabel);
        addressPanel.add(stateField);
        addressPanel.add(clearButton);
        addressPanel.add(updateNewAddressButton);  
        
        facilityPanel.add(emailPanel);
        emailPanel.add(oldEmailIdLabel);
        emailPanel.add(oldEmailIdField);
        emailPanel.add(emailIdLabel);
        emailPanel.add(emailIdField);
        emailPanel.add(updateEmailIDButton);
        
        facilityPanel.add(contactPanel);
        contactPanel.add(oldContactLabel);
        contactPanel.add(oldContactField);
        contactPanel.add(contactLabel);
        contactPanel.add(contactField);
        contactPanel.add(updateContactNoButton);
        
        mainPanel.add(logoutButton);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if ("Update Address".equals(event.getActionCommand())) {
           addressPanel.setVisible(true);emailPanel.setVisible(false); contactPanel.setVisible(false);
        }

        if ("Update EmailID".equals(event.getActionCommand())) {
           emailPanel.setVisible(true); addressPanel.setVisible(false);contactPanel.setVisible(false);
           clearButton.setVisible(true);
        }

        if ("Update Contact".equals(event.getActionCommand())) {
           contactPanel.setVisible(true); emailPanel.setVisible(false); addressPanel.setVisible(false);
        }
        

        if ("BACK".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to go BACK?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new ChooseFacility(applicantName);
            }
        }
        if ("LOGOUT".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to Logout ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new WelcomePage();
            }
        }

    }
   

    public static void main(String[] args) throws HeadlessException, ClassNotFoundException, SQLException {
        new KycUpdate("Prince");
    }

}
