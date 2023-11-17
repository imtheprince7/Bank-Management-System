package bank.management.system.administration;

import bank.management.system.accountRegistration.AccountRecovery;
import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.database.DatabaseConnection;
import bank.management.system.database.GenerateOTP;
import bank.management.system.database.PasswordEncryption;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;

public class AdministrationPage extends JFrame implements ActionListener {

    JPanel mainPanel, adminPanel, checkUserPanel, imagePanel;
    JLabel infoLabel, imagePicLabel, usernameLabel, fullNameLabel, mobileLabel, emailLabel, userTypeLabel, passwordLabel, cpasswordLabel, aadharCardLabel;
    JTextField usernameField, fullNameField, mobileField, emailField, passwordField, cpasswordField, aadharCardField;
    JButton createButton, clearButton, checkUsersButton, logoutButton, backButton, userLogOutButton;
    JComboBox roleTypeBox;
    String personName, userName, fullName, mobileNumber, emailId, aadharCard, accountType;
    static String password, confirmPassword, savePassword;

    private Connection connection;
    private Statement statement;

    public AdministrationPage() {
        setResizable(false);
        setLayout(null);
        setSize(900, 600);
        setLocation(250, 150);
        setTitle("Administration Panel");

        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setBackground(Color.ORANGE);
        mainPanel.setLayout(null);

        imagePanel = new JPanel();
        add(imagePanel);
        imagePanel.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img1 = img.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        imagePicLabel = new JLabel(img2);
        mainPanel.add(imagePicLabel);

        adminPanel = new JPanel();
        add(adminPanel);
        adminPanel.setBackground(Color.BLUE);
        adminPanel.setLayout(null);

        checkUserPanel = new JPanel();
        add(checkUserPanel);
        checkUserPanel.setBackground(Color.red);
        checkUserPanel.setLayout(null);
        checkUserPanel.setVisible(false);
        mainPanel.add(checkUserPanel);
        mainPanel.add(adminPanel);

        infoLabel = new JLabel("Create New Members");
        usernameLabel = new JLabel("UserName");
        usernameField = new JTextField();
        usernameField.setEditable(false);
        fullNameLabel = new JLabel("Full Name");
        fullNameField = new JTextField();

        mobileLabel = new JLabel("Mobile No");
        mobileField = new JTextField();
        emailLabel = new JLabel("Email Id");
        emailField = new JTextField();

        userTypeLabel = new JLabel("Account Type");
        String account_type[] = {"Select Role", "Admin", "Manager", "Staff"};
        roleTypeBox = new JComboBox(account_type);

        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        cpasswordLabel = new JLabel("Confirm Password");
        cpasswordField = new JPasswordField();

        aadharCardLabel = new JLabel("Aadhar Card");
        aadharCardField = new JTextField();

        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);
        clearButton.setForeground(Color.red);
        createButton = new JButton("CREATE USERS");
        createButton.addActionListener(this);

        checkUsersButton = new JButton("CHECK USERS");
        checkUsersButton.addActionListener(this);
        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(this);
        logoutButton.setForeground(Color.red);
        backButton = new JButton("BACK");

        backButton.addActionListener(this);
        backButton.setVisible(false);
        userLogOutButton = new JButton("LOGOUT");
        userLogOutButton.addActionListener(this);
        userLogOutButton.setVisible(false);

        addComponent();
        setBound();
        setFont();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setFont() {
        usernameLabel.setFont(new Font("verdana", Font.BOLD, 14));
        infoLabel.setFont(new Font("verdana", Font.BOLD, 16));
        fullNameLabel.setFont(new Font("verdana", Font.BOLD, 14));
        fullNameField.setFont(new Font("verdana", Font.BOLD, 14));
        mobileLabel.setFont(new Font("verdana", Font.BOLD, 14));
        mobileField.setFont(new Font("verdana", Font.BOLD, 14));
        emailLabel.setFont(new Font("verdana", Font.BOLD, 14));
        emailField.setFont(new Font("verdana", Font.BOLD, 14));
        aadharCardLabel.setFont(new Font("verdana", Font.BOLD, 14));
        aadharCardField.setFont(new Font("verdana", Font.BOLD, 14));
        userTypeLabel.setFont(new Font("verdana", Font.BOLD, 14));
        roleTypeBox.setFont(new Font("verdana", Font.BOLD, 14));
        passwordLabel.setFont(new Font("verdana", Font.BOLD, 14));
        passwordField.setFont(new Font("verdana", Font.BOLD, 14));
        cpasswordLabel.setFont(new Font("verdana", Font.BOLD, 14));
        cpasswordField.setFont(new Font("verdana", Font.BOLD, 14));
        backButton.setFont(new Font("verdana", Font.BOLD, 14));
        userLogOutButton.setFont(new Font("verdana", Font.BOLD, 14));
    }

    public void setBound() {
        mainPanel.setBounds(0, 0, 900, 600);
        adminPanel.setBounds(400, 0, 500, 600);
        checkUserPanel.setBounds(0, 0, 900, 500);
        imagePanel.setBounds(0, 0, 400, 600);
        infoLabel.setBounds(150, 20, 350, 50);

        usernameLabel.setBounds(20, 75, 150, 40);
        usernameField.setBounds(200, 75, 200, 40);
        fullNameLabel.setBounds(20, 120, 150, 40);
        fullNameField.setBounds(200, 120, 200, 40);

        mobileLabel.setBounds(20, 165, 160, 40);
        mobileField.setBounds(200, 165, 200, 40);
        emailLabel.setBounds(20, 210, 200, 40);
        emailField.setBounds(200, 210, 200, 40);
        aadharCardLabel.setBounds(20, 255, 200, 40);
        aadharCardField.setBounds(200, 255, 200, 40);

        userTypeLabel.setBounds(20, 310, 150, 40);
        roleTypeBox.setBounds(200, 310, 200, 30);
        passwordLabel.setBounds(20, 360, 150, 40);
        passwordField.setBounds(200, 360, 200, 40);
        cpasswordLabel.setBounds(20, 410, 180, 40);
        cpasswordField.setBounds(200, 410, 200, 40);

        clearButton.setBounds(100, 470, 150, 35);
        createButton.setBounds(300, 470, 150, 35);
        checkUsersButton.setBounds(300, 520, 150, 35);
        logoutButton.setBounds(390, 0, 100, 30);
        backButton.setBounds(500, 510, 150, 40);
        userLogOutButton.setBounds(730, 510, 150, 40);
    }

    public void addComponent() {
        mainPanel.add(imagePanel);
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
        adminPanel.add(logoutButton);
        mainPanel.add(backButton);
        mainPanel.add(userLogOutButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("LOGOUT".equals(e.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to Logout ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new WelcomePage();
            }

        }
        if ("CLEAR".equals(e.getActionCommand())) {
            usernameField.setText("");
            fullNameField.setText("");
            mobileField.setText("");
            emailField.setText("");
            aadharCardField.setText("");
            passwordField.setText("");
            cpasswordField.setText("");

        }
        if ("CREATE USERS".equals(e.getActionCommand())) {
            userName = getUserName();
            fullName = fullNameField.getText().trim();
            mobileNumber = mobileField.getText().trim();
            emailId = emailField.getText().toLowerCase().trim();
            aadharCard = aadharCardField.getText().trim();
            accountType = (String) roleTypeBox.getSelectedItem();
            password = passwordField.getText().trim();
            confirmPassword = cpasswordField.getText().trim();
            savePassword = PasswordEncryption.encryptAdminPassword();

            try {
                // Validating and Storing all data into Database;
                saveDataIntoDatabase();
            } catch (SQLException | ClassNotFoundException exception) {
                Logger.getLogger(AdministrationPage.class.getName()).log(Level.SEVERE, null, exception);
            }
        }

        if ("CHECK USERS".equals(e.getActionCommand())) {
            adminPanel.setVisible(false);
            checkUserPanel.setVisible(true);
            userLogOutButton.setVisible(true);
            backButton.setVisible(true);

        }
        if ("BACK".equals(e.getActionCommand())) {
            backButton.setVisible(false);
            userLogOutButton.setVisible(false);
            checkUserPanel.setVisible(false);
            adminPanel.setVisible(true);

        }
    }

    public void saveDataIntoDatabase() throws SQLException, ClassNotFoundException {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // First checking textFields are not empty and email Validation
        connection = DatabaseConnection.ConnectionString();
        statement = connection.createStatement();
        if (userName.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "UserName:  cannot be skip:");
        } else if (fullName.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Full Name:  cannot be empty:");
        } else if (mobileNumber.length() > 10) {
            JOptionPane.showMessageDialog(rootPane, "Mobile Number must have 10 digit:");
        } else if (mobileNumber.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Mobile Number:  cannot be empty:");
        } else if (emailField.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "email ID:  cannot be empty:");
        } else if (!Pattern.compile("^(.+)@(\\S+)$").matcher(emailId).matches()) {
            JOptionPane.showMessageDialog(rootPane, "Emter valid email id:");
        } else if (aadharCard.length() > 12) {
            JOptionPane.showMessageDialog(rootPane, "Aadhar Card must have 12 digit:");
        } else if (aadharCard.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Aadhar Card cannot be empty:");
        } else if (password.length() > 10) {
            JOptionPane.showMessageDialog(rootPane, "Password Length should be less than 7 :");
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Password cannot be empty:");
        } else if (confirmPassword.length() > 10) {
            JOptionPane.showMessageDialog(rootPane, "Password Length should be less than 7 :");
        } else if (!confirmPassword.equals(password)) {
            JOptionPane.showMessageDialog(rootPane, "Confirm Password is not Same:");
            return;
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * from user_details WHERE email_id = '" + emailId + "' OR mobile_no = '" + mobileNumber + "' OR user_aadhar_card = '" + aadharCard + "'");
            if (resultSet.next()) {
                int response = JOptionPane.showConfirmDialog(this, "Person is Already exist: !!\n" + "UserName: \t" + resultSet.getString("username") + "\n Account Type:: \t" + resultSet.getString("login_type"), "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    fullNameField.setText("");
                    mobileField.setText("");
                    emailField.setText("");
                    aadharCardField.setText("");
                    passwordField.setText("");
                    cpasswordField.setText("");
                }
                return;
            } else {
                String user_details = "INSERT INTO user_details(username, name, email_id, mobile_no, password, login_type, user_aadhar_card) VALUES"
                        + " ('" + userName + "', '" + fullName + "', '" + emailId + "', '" + mobileNumber + "', '" + savePassword + "', '" + accountType + "',  '" + aadharCard + "')";
                statement.executeUpdate(user_details);
                JOptionPane.showConfirmDialog(this, "Acoount created SuccessFully !!\n" + "UserName: \t" + userName + "\n Password: \t" + confirmPassword);
                fullNameField.setText("");
                mobileField.setText("");
                emailField.setText("");
                aadharCardField.setText("");
                passwordField.setText("");
                cpasswordField.setText("");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }

    public String getUserName() {
        return fullNameField.getText().substring(0, 6).toLowerCase().trim().concat(GenerateOTP.generateOTPForEmailVerification());
    }
    public static String encryptPassword() {
        return password;
    }
}
