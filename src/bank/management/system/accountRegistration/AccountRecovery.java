package bank.management.system.accountRegistration;

import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.database.DatabaseConnection;
import bank.management.system.database.MysqlJoinsClasses;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class AccountRecovery extends JFrame implements ActionListener {

    JPanel imagePanel, searchPanel, recoveryPanel, choosePanel, updatePanel;
    JLabel imageLabel, optionFirst, infoLabelFirst, emailLabelFirst, userNameLabelFirst, optionSecond, userNameLabelSecond,
            mobileLabelFirst, optionThird, emailLabelSecond, mobileLabelSecond, infoLabelSecond, accountNumberLabel, userNameLabelThird, nameLabel,
            emailLabelThird, mobileLabelThird, passwordLabelFirst, confirmPasswordLabelFirst;
    JTextField emailIdFieldFirst, userNameFieldFirst, userNameFieldSecond, mobileFieldFirst, emailFieldSecond, mobileFieldSecond,
            infoTextSecond, infoTextThird, accountNumberField, userNameFieldThird, nameField, emailFieldThird, mobileFieldThird, passwordField, confirmPasswordField;
    JButton searchButtonFirst, searchButtonSecond, searchButtonThird, clearButtonFirst, exitButton, mobileChooseButton, emailIdChooseButton,
            passwordChooseButton, exitButtonSecond, updateButton;
    boolean updateEmailId = false, updateContact = false, updatePassword = false;
    String regex = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";

    private Connection connection;
    private Statement statement;

    public AccountRecovery() throws SQLException, ClassNotFoundException {
        setResizable(false);
        setLayout(null);
        setSize(900, 600);
        setLocation(250, 150);
        setTitle("ACCOUNT RECOVERY WINDOW");

        imagePanel = new JPanel();
        add(imagePanel);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/forgetImage.png"));
        Image img1 = img.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        imageLabel = new JLabel(img2);

        searchPanel = new JPanel();
        searchPanel.setBackground(Color.blue);
        searchPanel.setLayout(null);
        add(searchPanel);

        infoLabelFirst = new JLabel("Recover your account details from given options");
        optionFirst = new JLabel("Option First");
        emailLabelFirst = new JLabel("Email Id");
        emailIdFieldFirst = new JTextField();
        userNameLabelFirst = new JLabel("Username");
        userNameFieldFirst = new JTextField();
        searchButtonFirst = new JButton("SEARCH");
        searchButtonFirst.addActionListener(this);

        optionSecond = new JLabel("Option Second");
        userNameLabelSecond = new JLabel("Username");
        userNameFieldSecond = new JTextField();
        mobileLabelFirst = new JLabel("Contact No");
        mobileFieldFirst = new JTextField();
        searchButtonSecond = new JButton("FIND");
        searchButtonSecond.addActionListener(this);

        optionThird = new JLabel("Option Third");
        emailLabelSecond = new JLabel("Email ID");
        emailFieldSecond = new JTextField();
        mobileLabelSecond = new JLabel("Contact No");
        mobileFieldSecond = new JTextField();
        searchButtonThird = new JButton("RECOVER");
        searchButtonThird.addActionListener(this);

        clearButtonFirst = new JButton("CLEAR");
        clearButtonFirst.addActionListener(this);
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);

        recoveryPanel = new JPanel();
        recoveryPanel.setBackground(Color.blue);
        recoveryPanel.setLayout(null);
        add(recoveryPanel);

        choosePanel = new JPanel();
        choosePanel.setBackground(Color.blue);
        choosePanel.setLayout(null);
        add(choosePanel);
        choosePanel.setVisible(false);

        updatePanel = new JPanel();
        updatePanel.setBackground(Color.blue);
        updatePanel.setLayout(null);
        add(updatePanel);
        updatePanel.setVisible(false);

        infoLabelSecond = new JLabel("Choose options to update");
        infoTextSecond = new JTextField();
        infoTextSecond.setEditable(false);

        mobileChooseButton = new JButton("Update Contact");
        mobileChooseButton.addActionListener(this);
        emailIdChooseButton = new JButton("Update EmailId");
        emailIdChooseButton.addActionListener(this);
        passwordChooseButton = new JButton("Update Password");
        passwordChooseButton.addActionListener(this);

        infoTextThird = new JTextField();
        infoTextThird.setEditable(false);

        accountNumberLabel = new JLabel("Account Number");
        accountNumberField = new JTextField();
        accountNumberField.setEditable(false);
        accountNumberField.setText(MysqlJoinsClasses.getaccountNumber());
        nameLabel = new JLabel("Candidate Name");
        nameField = new JTextField();
        nameField.setEditable(false);
        userNameLabelThird = new JLabel("Username");
        userNameFieldThird = new JTextField();
        userNameFieldThird.setEditable(false);
        emailLabelThird = new JLabel("Email ID");
        emailFieldThird = new JTextField();
        emailFieldThird.setEditable(false);
        mobileLabelThird = new JLabel("Contact Number");
        mobileFieldThird = new JTextField();
        mobileFieldThird.setEditable(false);
        passwordLabelFirst = new JLabel("Password");
        passwordField = new JTextField();
        passwordField.setEditable(false);
        confirmPasswordLabelFirst = new JLabel("Confirm Password");
        confirmPasswordField = new JTextField();
        confirmPasswordField.setEditable(false);

        exitButtonSecond = new JButton("EXIT");
        exitButtonSecond.addActionListener(this);
        updateButton = new JButton("UPDATE");
        updateButton.addActionListener(this);

        setFont();
        setBound();
        addComponent();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setFont() {
        optionFirst.setFont(new Font("verdana", Font.BOLD, 16));
        infoLabelFirst.setFont(new Font("verdana", Font.BOLD, 17));
        emailLabelFirst.setFont(new Font("verdana", Font.BOLD, 15));
        emailIdFieldFirst.setFont(new Font("verdana", Font.BOLD, 14));
        userNameLabelFirst.setFont(new Font("verdana", Font.BOLD, 15));
        userNameFieldFirst.setFont(new Font("verdana", Font.BOLD, 14));
        searchButtonFirst.setFont(new Font("verdana", Font.BOLD, 13));
        optionSecond.setFont(new Font("verdana", Font.BOLD, 16));
        userNameLabelSecond.setFont(new Font("verdana", Font.BOLD, 15));
        userNameFieldSecond.setFont(new Font("verdana", Font.BOLD, 14));
        mobileLabelFirst.setFont(new Font("verdana", Font.BOLD, 15));
        mobileFieldFirst.setFont(new Font("verdana", Font.BOLD, 14));
        searchButtonSecond.setFont(new Font("verdana", Font.BOLD, 13));
        optionThird.setFont(new Font("verdana", Font.BOLD, 16));
        emailLabelSecond.setFont(new Font("verdana", Font.BOLD, 15));
        emailFieldSecond.setFont(new Font("verdana", Font.BOLD, 14));
        mobileLabelSecond.setFont(new Font("verdana", Font.BOLD, 15));
        mobileFieldSecond.setFont(new Font("verdana", Font.BOLD, 14));
        searchButtonThird.setFont(new Font("verdana", Font.BOLD, 13));

        infoLabelSecond.setFont(new Font("verdana", Font.BOLD, 17));
        infoTextSecond.setFont(new Font("verdana", Font.BOLD, 16));
        mobileChooseButton.setFont(new Font("verdana", Font.BOLD, 13));
        emailIdChooseButton.setFont(new Font("verdana", Font.BOLD, 13));
        passwordChooseButton.setFont(new Font("verdana", Font.BOLD, 13));

        infoTextThird.setFont(new Font("verdana", Font.BOLD, 16));
        accountNumberLabel.setFont(new Font("verdana", Font.BOLD, 16));
        accountNumberField.setFont(new Font("verdana", Font.BOLD, 15));
        nameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        nameField.setFont(new Font("verdana", Font.BOLD, 15));
        userNameLabelThird.setFont(new Font("verdana", Font.BOLD, 16));
        userNameFieldThird.setFont(new Font("verdana", Font.BOLD, 15));
        emailLabelThird.setFont(new Font("verdana", Font.BOLD, 16));
        emailFieldThird.setFont(new Font("verdana", Font.BOLD, 15));
        mobileLabelThird.setFont(new Font("verdana", Font.BOLD, 16));
        mobileFieldThird.setFont(new Font("verdana", Font.BOLD, 15));
        passwordLabelFirst.setFont(new Font("verdana", Font.BOLD, 16));
        passwordField.setFont(new Font("verdana", Font.BOLD, 15));
        confirmPasswordLabelFirst.setFont(new Font("verdana", Font.BOLD, 12));
        confirmPasswordField.setFont(new Font("verdana", Font.BOLD, 13));
        exitButtonSecond.setFont(new Font("verdana", Font.BOLD, 13));
        updateButton.setFont(new Font("verdana", Font.BOLD, 13));

    }

    public void setBound() {
        imagePanel.setBounds(0, 0, 400, 600);
        imageLabel.setBounds(0, 0, 250, 500);
        searchPanel.setBounds(400, 0, 500, 600);
        recoveryPanel.setBounds(400, 0, 500, 600);
        choosePanel.setBounds(0, 0, 500, 150);
        updatePanel.setBounds(0, 0, 500, 600);

        infoLabelFirst.setBounds(20, 10, 500, 45);
        optionFirst.setBounds(0, 50, 500, 50);
        emailLabelFirst.setBounds(40, 100, 100, 40);
        emailIdFieldFirst.setBounds(150, 100, 200, 40);
        userNameLabelFirst.setBounds(40, 150, 100, 40);
        userNameFieldFirst.setBounds(150, 150, 200, 40);
        searchButtonFirst.setBounds(370, 130, 100, 40);

        optionSecond.setBounds(0, 200, 500, 50);
        userNameLabelSecond.setBounds(40, 250, 100, 40);
        userNameFieldSecond.setBounds(150, 250, 200, 40);
        mobileLabelFirst.setBounds(40, 300, 100, 40);
        mobileFieldFirst.setBounds(150, 300, 200, 40);
        searchButtonSecond.setBounds(370, 270, 100, 40);

        optionThird.setBounds(0, 350, 200, 50);
        emailLabelSecond.setBounds(40, 400, 100, 40);
        emailFieldSecond.setBounds(150, 400, 200, 40);
        mobileLabelSecond.setBounds(40, 450, 100, 40);
        mobileFieldSecond.setBounds(150, 450, 200, 40);
        searchButtonThird.setBounds(360, 420, 120, 40);
        clearButtonFirst.setBounds(240, 510, 100, 40);
        exitButton.setBounds(360, 510, 100, 40);

        infoLabelSecond.setBounds(20, 10, 300, 45);
        infoTextSecond.setBounds(270, 10, 200, 45);
        mobileChooseButton.setBounds(5, 90, 150, 40);
        emailIdChooseButton.setBounds(160, 90, 160, 40);
        passwordChooseButton.setBounds(325, 90, 160, 40);
// Now y-axis is: 150
        infoTextThird.setBounds(340, 10, 150, 40);
        accountNumberLabel.setBounds(20, 150, 150, 40);
        accountNumberField.setBounds(200, 150, 250, 40);
        nameLabel.setBounds(20, 200, 150, 40);
        nameField.setBounds(200, 200, 250, 40);
        userNameLabelThird.setBounds(20, 250, 200, 40);
        userNameFieldThird.setBounds(200, 250, 250, 40);
        emailLabelThird.setBounds(20, 300, 150, 40);
        emailFieldThird.setBounds(200, 300, 250, 40);
        mobileLabelThird.setBounds(20, 350, 150, 40);
        mobileFieldThird.setBounds(200, 350, 250, 40);
        passwordLabelFirst.setBounds(20, 400, 150, 40);
        passwordField.setBounds(200, 400, 250, 40);
        confirmPasswordLabelFirst.setBounds(20, 450, 150, 40);
        confirmPasswordField.setBounds(200, 450, 250, 40);
        exitButtonSecond.setBounds(150, 520, 150, 40);
        updateButton.setBounds(350, 520, 150, 40);
    }

    public void addComponent() {
        imagePanel.add(imageLabel);

        searchPanel.add(infoLabelFirst);
        searchPanel.add(optionFirst);
        searchPanel.add(emailLabelFirst);
        searchPanel.add(emailIdFieldFirst);
        searchPanel.add(userNameLabelFirst);
        searchPanel.add(userNameFieldFirst);
        searchPanel.add(optionSecond);
        searchPanel.add(userNameLabelSecond);
        searchPanel.add(userNameFieldSecond);
        searchPanel.add(mobileLabelFirst);
        searchPanel.add(mobileFieldFirst);
        searchPanel.add(searchButtonFirst);

        searchPanel.add(optionThird);
        searchPanel.add(searchButtonSecond);
        searchPanel.add(emailLabelSecond);
        searchPanel.add(emailFieldSecond);
        searchPanel.add(mobileLabelSecond);
        searchPanel.add(mobileFieldSecond);
        searchPanel.add(searchButtonThird);
        searchPanel.add(clearButtonFirst);
        searchPanel.add(exitButton);

        recoveryPanel.add(choosePanel);
        recoveryPanel.add(updatePanel);
        choosePanel.add(infoLabelSecond);
        choosePanel.add(infoTextSecond);
        choosePanel.add(mobileChooseButton);
        choosePanel.add(emailIdChooseButton);
        choosePanel.add(passwordChooseButton);

        updatePanel.add(infoTextThird);
        updatePanel.add(accountNumberLabel);
        updatePanel.add(accountNumberField);
        updatePanel.add(nameLabel);
        updatePanel.add(nameField);
        updatePanel.add(userNameLabelThird);
        updatePanel.add(userNameFieldThird);
        updatePanel.add(emailLabelThird);
        updatePanel.add(emailFieldThird);
        updatePanel.add(mobileLabelThird);
        updatePanel.add(mobileFieldThird);
        updatePanel.add(passwordLabelFirst);
        updatePanel.add(passwordField);
        updatePanel.add(confirmPasswordLabelFirst);
        updatePanel.add(confirmPasswordField);
        updatePanel.add(exitButtonSecond);
        updatePanel.add(updateButton);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if ("SEARCH".equals(event.getActionCommand())) {
            if (emailIdFieldFirst.getText().toLowerCase().trim().isEmpty() && userNameFieldFirst.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Can't retrieve fields are empty !! \n\n");
                searchButtonFirst.setForeground(Color.RED);

            } else if (emailIdFieldFirst.getText().toLowerCase().trim().isEmpty() || userNameFieldFirst.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "UserName or Password can't be empty: \n\n");
                emailIdFieldFirst.setText("");
                userNameFieldFirst.setText("");
            } else if (!Pattern.compile("^(.+)@(\\S+)$").matcher(emailIdFieldFirst.getText().trim()).matches()) {
                JOptionPane.showMessageDialog(rootPane, "Enter valid email id:");
            } else {
                try {
                    connection = DatabaseConnection.ConnectionString();
                    statement = connection.createStatement();
                    ResultSet resultSetFirst = statement.executeQuery("select * from user_details where username='" + userNameFieldFirst.getText().toLowerCase().trim().equalsIgnoreCase(userNameFieldFirst.getText()) + "'"
                            + " AND email_id ='" + emailIdFieldFirst.getText().toLowerCase().trim().equalsIgnoreCase(emailIdFieldFirst.getText()) + "'");
// ResultSet for SearchButtonFirst:     SEARCH
                    if (resultSetFirst.next()) {
                        userNameFieldThird.setText(resultSetFirst.getString("userName"));
                        infoTextSecond.setText(resultSetFirst.getString("name"));
                        nameField.setText(resultSetFirst.getString("name"));
                        infoTextThird.setText(resultSetFirst.getString("name"));
                        emailFieldThird.setText(resultSetFirst.getString("email_id"));
                        mobileFieldThird.setText(resultSetFirst.getString("mobile_no"));
                        passwordField.setText(resultSetFirst.getString("password"));
                        confirmPasswordField.setText(resultSetFirst.getString("password"));
                        searchPanel.setVisible(false);
                        recoveryPanel.setVisible(true);
                        choosePanel.setVisible(true);
                    } else {
                        int response = JOptionPane.showConfirmDialog(this, "Person doesn't exist: !!\n Do you want to register yourself:", "CONFIRM",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            dispose();
                            new AccountRegisteration();
                            return;
                        } else if (response == JOptionPane.NO_OPTION || response == JOptionPane.CANCEL_OPTION) {
                            emailIdFieldFirst.setText("");
                            userNameFieldFirst.setText("");
                            return;
                        }
                    }
                } catch (SQLException | ClassNotFoundException exception) {
                    Logger.getLogger(AccountRecovery.class.getName()).log(Level.SEVERE, null, exception);
                } finally {
                    try {
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountRecovery.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        if ("FIND".equals(event.getActionCommand())) {
            if (userNameFieldSecond.getText().trim().isEmpty() && mobileFieldFirst.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Can't retrieve fields are empty!! \n\n");
                searchButtonSecond.setForeground(Color.RED);
            } else if (userNameFieldSecond.getText().trim().isEmpty() || mobileFieldFirst.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "UserName or Password can't be empty \n\n");
                userNameFieldSecond.setText("");
                mobileFieldFirst.setText("");
            } else if (mobileFieldFirst.getText().length() > 10) {
                JOptionPane.showMessageDialog(rootPane, "Mobile Number must have 10 digits:");
            } else {
                try {
                    connection = DatabaseConnection.ConnectionString();
                    statement = connection.createStatement();

// ResultSet for SearchButtonSecond:    FIND
                    ResultSet resultSetSecond = statement.executeQuery("select * from user_details where username='" + userNameFieldSecond.getText().toLowerCase().trim() + "'"
                            + " AND mobile_no= '" + mobileFieldFirst.getText().trim() + "'");

                    if (resultSetSecond.next()) {
                        userNameFieldThird.setText(resultSetSecond.getString("userName"));
                        infoTextSecond.setText(resultSetSecond.getString("name"));
                        nameField.setText(resultSetSecond.getString("name"));
                        infoTextThird.setText(resultSetSecond.getString("name"));
                        emailFieldThird.setText(resultSetSecond.getString("email_id"));
                        mobileFieldThird.setText(resultSetSecond.getString("mobile_no"));
                        passwordField.setText(resultSetSecond.getString("password"));
                        confirmPasswordField.setText(resultSetSecond.getString("password"));
                        searchPanel.setVisible(false);
                        recoveryPanel.setVisible(true);
                        choosePanel.setVisible(true);
                    } else {
                        int response = JOptionPane.showConfirmDialog(this, "Person doesn't exist: !!\n Do you want to register yourself:", "CONFIRM",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            dispose();
                            new AccountRegisteration();
                            return;
                        } else if (response == JOptionPane.NO_OPTION || response == JOptionPane.CANCEL_OPTION) {
                            userNameFieldSecond.setText("");
                            mobileFieldFirst.setText("");
                            return;
                        }
                    }

                } catch (SQLException | ClassNotFoundException exception) {
                    Logger.getLogger(AccountRecovery.class.getName()).log(Level.SEVERE, null, exception);
                } finally {
                    try {
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountRecovery.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        if ("RECOVER".equals(event.getActionCommand())) {
            if (emailFieldSecond.getText().toLowerCase().trim().isEmpty() && mobileFieldSecond.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Can't retrieve fields are empty !!\n\n");
                emailFieldSecond.setForeground(Color.RED);
            } else if (emailFieldSecond.getText().toLowerCase().trim().isEmpty() || mobileFieldSecond.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "emailId or Mobile number can't be empty:\n\n");
                emailFieldSecond.setText("");
                mobileFieldSecond.setText("");
            } else if (mobileFieldSecond.getText().length() > 10) {
                JOptionPane.showMessageDialog(rootPane, "Mobile Number must have 10 digit:");
            } else if (!Pattern.compile("^(.+)@(\\S+)$").matcher(emailFieldSecond.getText().trim()).matches()) {
                JOptionPane.showMessageDialog(rootPane, "Enter valid email id:");
            } else {
                try {
                    connection = DatabaseConnection.ConnectionString();
                    statement = connection.createStatement();
// ResultSet for SearchButtonSecond:    RECOVER
                    ResultSet resultSetThird = statement.executeQuery("select * from user_details where email_id='" + emailFieldSecond.getText().toLowerCase().trim() + "'"
                            + " AND mobile_no = '" + mobileFieldSecond.getText().trim() + "'");

                    if (resultSetThird.next()) {
//                        personAadharCard = resultSetThird.getString("user_aadhar_card");
                        userNameFieldThird.setText(resultSetThird.getString("userName"));
                        infoTextSecond.setText(resultSetThird.getString("name"));
                        nameField.setText(resultSetThird.getString("name"));
                        infoTextThird.setText(resultSetThird.getString("name"));
                        emailFieldThird.setText(resultSetThird.getString("email_id"));
                        mobileFieldThird.setText(resultSetThird.getString("mobile_no"));
                        passwordField.setText(resultSetThird.getString("password"));
                        confirmPasswordField.setText(resultSetThird.getString("password"));
                        searchPanel.setVisible(false);
                        recoveryPanel.setVisible(true);
                        choosePanel.setVisible(true);
                        return;
                    } else {
                        int response = JOptionPane.showConfirmDialog(this, "Person doesn't exist: !!\n Do you want to register yourself:",
                                "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            dispose();
                            new AccountRegisteration();
                        } else if (response == JOptionPane.NO_OPTION || response == JOptionPane.CANCEL_OPTION) {
                            emailFieldSecond.setText("");
                            mobileFieldSecond.setText("");
                            return;
                        }
                    }
                } catch (SQLException | ClassNotFoundException exception) {
                    Logger.getLogger(AccountRecovery.class.getName()).log(Level.SEVERE, null, exception);
                } finally {
                    try {
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountRecovery.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }

        if ("CLEAR".equals(event.getActionCommand())) {
            emailIdFieldFirst.setText("");
            userNameFieldFirst.setText("");
            userNameFieldSecond.setText("");
            mobileFieldFirst.setText("");
            emailIdFieldFirst.setText("");
            mobileFieldSecond.setText("");

        }

        if ("EXIT".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to EXIT ?", "CONFIRM",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new WelcomePage();
            }
        }

        if ("Update Contact".equals(event.getActionCommand())) {
            updateContact = true;
            choosePanel.setVisible(false);
            updatePanel.setVisible(true);
            mobileFieldThird.setText("");
            mobileFieldThird.setEditable(true);
        }

        if ("Update EmailId".equals(event.getActionCommand())) {
            updateEmailId = true;
            choosePanel.setVisible(false);
            updatePanel.setVisible(true);
            emailFieldThird.setText("");
            emailFieldThird.setEditable(true);

        }
        if ("Update Password".equals(event.getActionCommand())) {
            updatePassword = true;
            choosePanel.setVisible(false);
            updatePanel.setVisible(true);
            passwordField.setText("");
            passwordField.setEditable(true);
            confirmPasswordField.setText("");
            confirmPasswordField.setEditable(true);
        }
        if ("UPDATE".equals(event.getActionCommand())) {
            // Calling Connection:
            try {
                connection = DatabaseConnection.ConnectionString();
                statement = connection.createStatement();
                String mobile_number = mobileFieldThird.getText().trim();
                String user_name = userNameFieldThird.getText().toLowerCase().trim();
                String email_id = emailFieldThird.getText().trim(), userPassword = passwordField.getText().trim();

// UPDATE BLOCK OF MOBILE_NUMBER:
                if (updateContact == true) {

                    if (mobileFieldThird.getText().toLowerCase().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Mobile number field can't be empty!! \n\n");
                        emailFieldSecond.setForeground(Color.RED);
                    } else if (mobileFieldThird.getText().toLowerCase().trim().length() > 10) {
                        JOptionPane.showMessageDialog(null, "Mobile number field \n can't be more than 10 digits: \n\n");
                        mobileFieldThird.setForeground(Color.RED);
                        mobileFieldThird.setText("");
                    } else {
                        String updateMobile = "UPDATE user_details SET mobile_no = '" + mobile_number + "' WHERE username = '" + user_name + "'";
                        int rowsAffected = statement.executeUpdate(updateMobile);
                        if (rowsAffected == 1) {
                            JOptionPane.showMessageDialog(null, "Mobile number has been Updated ❤️ \n\n");
                            mobileFieldThird.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "OOPS....!! \n Mobile number has not been Updated ❤️ \n\n");
                            mobileFieldThird.setText("");
                            mobileFieldThird.setForeground(Color.RED);
                        }
                    }
                }
// UPDATE BLOCK for Email-ID:
                if (updateEmailId == true) {
                    if (emailFieldThird.getText().toLowerCase().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Email-ID Field can't be empty!!  \n\n");
                        emailFieldSecond.setForeground(Color.RED);
                    } else if (!Pattern.compile("^(.+)@(\\S+)$").matcher(emailFieldThird.getText().trim()).matches()) {
                        JOptionPane.showMessageDialog(rootPane, "Enter valid email id:");
                        emailFieldSecond.setText("");
                    } else {
                        String updateEmail = "UPDATE user_details SET email_id = '" + email_id + "' WHERE username = '" + user_name + "'";
                        int rowsAffected = statement.executeUpdate(updateEmail);
                        if (rowsAffected == 1) {
                            JOptionPane.showMessageDialog(null, "Email-ID has been Updated ❤️ \n\n");
                            passwordField.setText("");
                            confirmPasswordField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "OOPS....!! \n Email-ID has not been Updated ❤️ \n\n");
                            passwordField.setText("");
                            confirmPasswordField.setText("");
                        }
                    }
                }
// UPDATE BLOCK OF Password:
                if (updatePassword == true) {
                    if (passwordField.getText().trim().isEmpty() && confirmPasswordField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Password Field can't be empty!!  \n\n");
                        mobileFieldThird.setForeground(Color.RED);
                        mobileFieldThird.setText("");
                    } else if (!confirmPasswordField.getText().equals(passwordField.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "Confirm Password is not Same:");
                        passwordField.setForeground(Color.RED);
                        confirmPasswordField.setForeground(Color.RED);
                        passwordField.setText("");
                        confirmPasswordField.setText("");
                    } else {
                        String updatePassword = "UPDATE user_details SET password = '" + userPassword + "' WHERE username = '" + user_name + "'";
                        int rowsAffected = statement.executeUpdate(updatePassword);
                        if (rowsAffected == 1) {
                            JOptionPane.showMessageDialog(null, "Password has been Updated ❤️ \n\n");
                            passwordField.setText("");
                            confirmPasswordField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "OOPS....!! \n Password has not been Updated ❤️ \n\n");
                            passwordField.setText("");
                            confirmPasswordField.setText("");
                        }
                    }
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AccountRecovery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ClassNotFoundException {
        new AccountRecovery();
    }
}
