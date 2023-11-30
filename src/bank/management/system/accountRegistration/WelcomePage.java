package bank.management.system.accountRegistration;

import bank.management.system.administration.AdministrationPage;
import bank.management.system.administration.ManagerPage;
import bank.management.system.administration.StaffPage;
import bank.management.system.bankfacility.ChooseFacility;
import bank.management.system.database.DatabaseConnection;
import bank.management.system.database.EmailOtpVerification;
import bank.management.system.database.MysqlJoinsClasses;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WelcomePage extends JFrame implements ActionListener {

    JPanel panelImage, panelContent, emailOtpPanel;
    JLabel imageLabel, messgaeLabel, usernameLabel, passwordLabel, loginTypeLabel, emailOtpLabel;
    static JTextField usernameField, passwordField, loginTypeField, emailOtpField;
    JButton registerButton, signInButton, forgetpassowrdButton, verifyEmailButton;

    public static String currentUserId = "", loginedName ="";
    long startTime = System.currentTimeMillis(), elapsedTime = 0L;
    public static String currentUserName = "";
    public String OTP = EmailOtpVerification.generateOTP().toString();
    public int state = -1;

    private Connection connection;
    private Statement statement;

    public WelcomePage() {

        setLayout(null);
        setResizable(false);
        setSize(920, 500);
        setLocation(200, 100);
        setTitle("CEGIAN BANK");

        panelImage = new JPanel();
        add(panelImage);
        panelImage.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img1 = img.getImage().getScaledInstance(350, 500, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        imageLabel = new JLabel(img2);
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

    public void setFont() {
        messgaeLabel.setFont(new Font("verdana", Font.BOLD, 28));
        usernameLabel.setFont(new Font("verdana", Font.BOLD, 15));
        usernameField.setFont(new Font("verdana", Font.BOLD, 15));
        passwordLabel.setFont(new Font("verdana", Font.BOLD, 15));
        passwordField.setFont(new Font("verdana", Font.BOLD, 15));
        signInButton.setFont(new Font("verdana", Font.BOLD, 15));
        registerButton.setFont(new Font("verdana", Font.BOLD, 15));
        forgetpassowrdButton.setFont(new Font("verdana", Font.BOLD, 15));
    }

    public void setBound() {
        imageLabel.setBounds(0, 0, 350, 500);
        panelImage.setBounds(0, 0, 350, 500);
        panelContent.setBounds(355, 0, 500, 500);
        emailOtpPanel.setBounds(0, 350, 500, 130);

        messgaeLabel.setBounds(50, 50, 450, 40);
        usernameLabel.setBounds(40, 150, 100, 50);
        usernameField.setBounds(150, 150, 250, 40);
        passwordLabel.setBounds(40, 225, 250, 20);
        passwordField.setBounds(150, 220, 250, 40);
        signInButton.setBounds(150, 300, 150, 40);
        registerButton.setBounds(350, 300, 150, 40);
        forgetpassowrdButton.setBounds(220, 360, 200, 40);

        loginTypeLabel.setBounds(10, 350, 50, 20);
        loginTypeField.setBounds(70, 350, 200, 30);
        emailOtpLabel.setBounds(10, 380, 50, 20);
        emailOtpField.setBounds(70, 380, 200, 30);
        verifyEmailButton.setBounds(300, 380, 100, 30);
    }

    public void addComponent() {
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

    @Override
    public void actionPerformed(ActionEvent event) {
        if ("Forget password".equals(event.getActionCommand())) {
            dispose();
            try {
                new AccountRecovery() ;
            } catch (SQLException | ClassNotFoundException exception) {
                Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, exception);
            } 
        }
        if ("Register".equals(event.getActionCommand())) {
            dispose();
            new AccountRegisteration();
        }

        if ("Sign In".equals(event.getActionCommand())) {
            if (usernameField.getText().trim().isEmpty() && passwordField.getText().trim().isEmpty()) {
                usernameField.setFocusable(true);
                JOptionPane.showMessageDialog(null, "Login Credential cannot be empty !! \n\n");
                signInButton.setForeground(Color.RED);
            } else if (usernameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "UserName or Password cannot be empty: \n\n");
                usernameField.setText("");
                passwordField.setText("");
            } else {
                try {
                    connection = DatabaseConnection.ConnectionString();
                    statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery("select * from user_details where username='" + usernameField.getText().trim() + "'"
                            + " AND password='" + passwordField.getText().trim() + "'");
                    if (resultSet.next()) {
                        String loginType = resultSet.getString("login_type");
                        loginedName = resultSet.getString("name").toString();
                        System.out.println("Getting name is:"+" "+loginedName);
                        System.err.println("Loggined Type is:"+" "+loginType);
                        MysqlJoinsClasses.getUserName(loginedName);
                        
                        if ("Admin".equals(loginType)) {
                            emailOtpPanel.setVisible(true);

                            state = 1;
                            System.err.println("Your Login OTP is: \t" + OTP);
                            EmailOtpVerification.sendEmail(OTP, resultSet.getString("name"),
                                    resultSet.getString("username"), resultSet.getString("email_id"));
                            currentUserId = usernameField.getText().trim();
                            currentUserName = resultSet.getString("name");

                            dispose();
                            new AdministrationPage();

                        } else if ("Manager".equals(loginType)) {
                            emailOtpPanel.setVisible(true);
                            new ManagerPage(loginedName);
                        } else if ("Staff".equals(loginType)) {
                            emailOtpPanel.setVisible(true);
                            new StaffPage(loginedName);
                        } else if ("customer".equals(loginType)) {
                            dispose();
                            new ChooseFacility(loginedName);
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid username or password");
                            usernameField.setText("");
                            passwordField.setText("");
                        }
                    }
                } catch (HeadlessException | ClassNotFoundException | SQLException exception) {
                    Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, exception);
                } finally {
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

    public static void main(String[] args) {
        new WelcomePage();
    }
}

// Login BUtton Work Models:
/*
1. Check Whether USername || password any one || both are blank 
2. If username hold ADMIN/MANAGER/STAFF then => "EMAIL-OTP-VERIFICATION" => redirect ROLE-BASED-PAGE
3. IF username hold registered Account-Person then redirect Banking-Facilities: ( with username|| Name on the page)
4. If Given-value is not registerd then SHOW ERROR MESSAGE => Not Registered in our Server then ==> Redirect directly AccountRegistration --Page:


 */
