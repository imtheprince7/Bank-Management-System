package bank.management.system.accountRegistration;

import bank.management.system.accountRegistration.AccountRegisterationSecond;
import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.database.DatabaseConnection;
import bank.management.system.database.EmailOtpVerification;
import bank.management.system.database.PasswordEncryption;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class AccountRegisteration extends JFrame implements ActionListener {

    String formNumber, userApplication, userApplicationNumber, firstName, lastName, customerName, fatherName, motherName,
            dob, gender, martialStatus, emailId, mobileNo, panCard, aadharCard, login_type = "customer";
    JPanel PanelMain;
    JLabel ImageLabel, applicationNoLabel, usernameLabel, firstNameLabel, lastNameLabel, fatherNameLabel,
            motherNameLabel, dobLabel, genderLabel, martialStatusLabel, emailIdLabel, mobileNoLabel,
            panCardLabel, aadharcardLabel;
    static JTextField applicationNoField, usernameField, firstNameField, lastNameField, fatherNameField,
            motherNameField, emailidField, mobileNoField, panCardField, aadharcardField;
    JRadioButton genderMale, genderFemale, buttonMarried, buttonsSingle, buttonDivorce;
    ButtonGroup genderGroup, martialStatusGroup;
    JButton exitButton, clearButton, nextButton;
    JDateChooser dateChooser;
    public static String password;
    private Connection connection;
    private Statement statement;

    AccountRegisteration() {
        formNumber = EmailOtpVerification.getFormNumber();
        password = PasswordEncryption.encryptPassword();
        System.out.println("Encrypted Password:" + " " + password);

        setTitle("Account Registration || Personal Details (1/3)");
        setResizable(false);
        setLayout(null);
        setSize(900, 550);
        setLocation(200, 100);

        PanelMain = new JPanel();
        PanelMain.setBounds(0, 0, 900, 550);
        add(PanelMain);
        PanelMain.setLayout(null);

        // IMAGE ICON LOADER
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image img1 = img.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        ImageLabel = new JLabel(img2);
        ImageLabel.setBounds(450, 0, 500, 100);
        PanelMain.add(ImageLabel);

        applicationNoLabel = new JLabel("Application Number");
        applicationNoField = new JTextField();
        applicationNoField.setText(formNumber);
        applicationNoField.setEditable(false);
        userApplication = formNumber.substring(0, 5);

        usernameLabel = new JLabel("Username");
        usernameField = new JTextField();
        usernameField.setEditable(false);

        firstNameLabel = new JLabel("First Name");
        firstNameField = new JTextField();

        lastNameLabel = new JLabel("Last Name");
        lastNameField = new JTextField();

        fatherNameLabel = new JLabel("Father Name");
        fatherNameField = new JTextField();

        motherNameLabel = new JLabel("Mother Name");
        motherNameField = new JTextField();

        dobLabel = new JLabel("D.O.B.");
        dateChooser = new JDateChooser();

        genderLabel = new JLabel("Gender");
        genderMale = new JRadioButton("MALE", true);
        genderFemale = new JRadioButton("FEMALE");

        genderGroup = new ButtonGroup();
        genderGroup.add(this.genderMale);
        genderGroup.add(this.genderFemale);

        martialStatusLabel = new JLabel("Martial Status");
        buttonsSingle = new JRadioButton("SINGLE", true);
        buttonMarried = new JRadioButton("MARRIED");
        buttonDivorce = new JRadioButton("DIVORCE");
        martialStatusGroup = new ButtonGroup();
        martialStatusGroup.add(this.buttonMarried);
        martialStatusGroup.add(this.buttonsSingle);
        martialStatusGroup.add(this.buttonDivorce);

        emailIdLabel = new JLabel("Email ID");
        emailidField = new JTextField();

        mobileNoLabel = new JLabel("Mobile Number");
        mobileNoField = new JTextField();

        panCardLabel = new JLabel("PANCARD NO");
        panCardField = new JTextField();

        aadharcardLabel = new JLabel("Aadhar Number");
        aadharcardField = new JTextField();

        exitButton = new JButton("EXIT");
        exitButton.setForeground(Color.red);
        exitButton.addActionListener(this);

        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);

        nextButton = new JButton("NEXT");
        nextButton.addActionListener(this);

        setFont();
        setBound();
        addComponent();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addComponent() {
        PanelMain.add(applicationNoLabel);
        PanelMain.add(applicationNoField);
        PanelMain.add(usernameLabel);
        PanelMain.add(usernameField);
        PanelMain.add(firstNameLabel);
        PanelMain.add(firstNameField);
        PanelMain.add(lastNameLabel);
        PanelMain.add(lastNameField);
        PanelMain.add(fatherNameLabel);
        PanelMain.add(fatherNameField);
        PanelMain.add(motherNameLabel);
        PanelMain.add(motherNameField);
        PanelMain.add(dobLabel);
        PanelMain.add(dateChooser);
        PanelMain.add(genderLabel);
        PanelMain.add(genderMale);
        PanelMain.add(genderFemale);
        PanelMain.add(martialStatusLabel);
        PanelMain.add(buttonMarried);
        PanelMain.add(buttonsSingle);
        PanelMain.add(buttonDivorce);
        PanelMain.add(emailIdLabel);
        PanelMain.add(emailidField);
        PanelMain.add(mobileNoLabel);
        PanelMain.add(mobileNoField);
        PanelMain.add(panCardLabel);
        PanelMain.add(panCardField);
        PanelMain.add(aadharcardLabel);
        PanelMain.add(aadharcardField);
        PanelMain.add(exitButton);
        PanelMain.add(clearButton);
        PanelMain.add(nextButton);

    }

    public void setFont() {
        applicationNoLabel.setFont(new Font("verdana", Font.BOLD, 12));
        applicationNoField.setFont(new Font("verdana", Font.BOLD, 14));
        usernameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        usernameField.setFont(new Font("verdana", Font.BOLD, 18));
        firstNameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        firstNameField.setFont(new Font("verdana", Font.ITALIC, 16));
        lastNameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        lastNameField.setFont(new Font("verdana", Font.ITALIC, 16));
        fatherNameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        fatherNameField.setFont(new Font("verdana", Font.ITALIC, 16));
        motherNameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        motherNameField.setFont(new Font("verdana", Font.ITALIC, 16));
        dobLabel.setFont(new Font("verdana", Font.BOLD, 16));
        genderLabel.setFont(new Font("verdana", Font.BOLD, 16));
        genderMale.setFont(new Font("verdana", Font.BOLD, 13));
        genderFemale.setFont(new Font("verdana", Font.BOLD, 13));
        martialStatusLabel.setFont(new Font("verdana", Font.BOLD, 16));
        buttonDivorce.setFont(new Font("verdana", Font.BOLD, 13));
        buttonMarried.setFont(new Font("verdana", Font.BOLD, 13));
        buttonsSingle.setFont(new Font("verdana", Font.BOLD, 13));
        emailIdLabel.setFont(new Font("verdana", Font.BOLD, 16));
        emailidField.setFont(new Font("verdana", Font.BOLD, 14));
        mobileNoLabel.setFont(new Font("verdana", Font.BOLD, 16));
        mobileNoField.setFont(new Font("verdana", Font.ITALIC, 14));
        panCardLabel.setFont(new Font("verdana", Font.BOLD, 16));
        panCardField.setFont(new Font("verdana", Font.ITALIC, 14));
        aadharcardLabel.setFont(new Font("verdana", Font.BOLD, 16));
        aadharcardField.setFont(new Font("verdana", Font.ITALIC, 14));
        exitButton.setFont(new Font("verdana", Font.BOLD, 15));
        clearButton.setFont(new Font("verdana", Font.BOLD, 15));
        nextButton.setFont(new Font("verdana", Font.BOLD, 15));
    }

    public void setBound() {
        applicationNoLabel.setBounds(20, 10, 150, 40);
        applicationNoField.setBounds(200, 10, 200, 30);
        usernameLabel.setBounds(20, 60, 150, 40);
        usernameField.setBounds(200, 60, 200, 40);
        firstNameLabel.setBounds(20, 110, 150, 40);
        firstNameField.setBounds(200, 110, 200, 40);
        lastNameLabel.setBounds(450, 110, 150, 40);
        lastNameField.setBounds(650, 110, 200, 40);
        fatherNameLabel.setBounds(20, 160, 150, 40);
        fatherNameField.setBounds(200, 160, 200, 40);
        motherNameLabel.setBounds(450, 160, 150, 40);
        motherNameField.setBounds(650, 160, 200, 40);
        dobLabel.setBounds(20, 210, 150, 40);
        dateChooser.setBounds(200, 210, 200, 40);
        genderLabel.setBounds(450, 210, 150, 40);
        genderMale.setBounds(650, 210, 100, 40);
        genderFemale.setBounds(770, 210, 150, 40);
        martialStatusLabel.setBounds(20, 260, 150, 40);
        buttonsSingle.setBounds(200, 260, 150, 40);
        buttonMarried.setBounds(400, 260, 150, 40);
        buttonDivorce.setBounds(600, 260, 150, 40);
        emailIdLabel.setBounds(20, 310, 150, 40);
        emailidField.setBounds(200, 310, 200, 40);
        mobileNoLabel.setBounds(450, 310, 150, 40);
        mobileNoField.setBounds(650, 310, 200, 40);
        panCardLabel.setBounds(20, 360, 150, 40);
        panCardField.setBounds(200, 360, 200, 40);
        aadharcardLabel.setBounds(450, 360, 150, 40);
        aadharcardField.setBounds(650, 360, 200, 40);
        exitButton.setBounds(450, 440, 100, 40);
        clearButton.setBounds(600, 440, 100, 40);
        nextButton.setBounds(750, 440, 100, 40);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("EXIT".equals(e.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to EXIT ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new WelcomePage();
            }
        }
        if ("CLEAR".equals(e.getActionCommand())) {

            int response = JOptionPane.showConfirmDialog(this, "Do You Want to CLEAR ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                usernameField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                fatherNameField.setText("");
                motherNameField.setText("");
                emailidField.setText("");
                mobileNoField.setText("");
                aadharcardField.setText("");
                panCardField.setText("");
            }
        }

        if ("NEXT".equals(e.getActionCommand())) {
            userApplicationNumber = applicationNoField.getText().trim();
            firstName = firstNameField.getText().trim();
            lastName = lastNameField.getText().trim();
            customerName = firstName + " " + lastName;
            fatherName = fatherNameField.getText().trim();
            motherName = motherNameField.getText().trim();
            dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            gender = getGender();
            martialStatus = getMartialStatus();
            emailId = emailidField.getText().toLowerCase().trim();
            mobileNo = mobileNoField.getText().trim();
            panCard = panCardField.getText().toLowerCase().trim();
            aadharCard = aadharcardField.getText().trim();

            // Validating and Storing all data into Database;
            try {
                saveDataIntoDatabase();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(AccountRegisteration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getUserName() {
        return (firstNameField.getText().toLowerCase().substring(0, 6).trim().concat(userApplication));
    }

    public String getGender() {
        String gender = null;
        if (genderMale.isSelected()) {
            gender = "MALE";
        } else if (genderFemale.isSelected()) {
            gender = "FEMALE";
        }
        return gender;
    }

    public String getMartialStatus() {
        String martialStatus = null;
        if (buttonMarried.isSelected()) {
            martialStatus = "MARRIED";
        } else if (buttonsSingle.isSelected()) {
            martialStatus = "SINGLE";
        } else {
            martialStatus = "DIVORCE";
        }
        return martialStatus;
    }

    public void saveDataIntoDatabase() throws SQLException, ClassNotFoundException {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // First checking textFields are not empty and email Validation
        connection = DatabaseConnection.ConnectionString();
        statement = connection.createStatement();
        try {
            if (firstName.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "FIRST_NAME:  cannot be empty:");
            } else if (firstName.length() > 15) {
                JOptionPane.showMessageDialog(rootPane, "Firstname field can't have more than 15 characters:");
            } else if (lastName.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "LAST_NAME: cannot be empty:");
            } else if (lastName.length() > 25) {
                JOptionPane.showMessageDialog(rootPane, "Lastname field can't have more than 25 characters:");
            } else if (fatherName.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "FATHER_NAME:  cannot be empty:");
            } else if (fatherName.length() > 25) {
                JOptionPane.showMessageDialog(rootPane, "Father Name field can't have more than 25 characters:");
            } else if (motherName.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "MOTHER_NAME:  cannot be empty:");
            } else if (motherName.length() > 25) {
                JOptionPane.showMessageDialog(rootPane, "Mother Name field can't have more than 25 characters:");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "D.O.B. cannot be empty:");
            } else if (emailId.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "EMAIL-ID: cannot be empty:");
            } else if (emailId.length() > 25) {
                JOptionPane.showMessageDialog(rootPane, "Email id length should be less than 25:");
            } else if (!Pattern.compile("^(.+)@(\\S+)$").matcher(emailId).matches()) {
                JOptionPane.showMessageDialog(rootPane, "Enter valid email ID");
                emailidField.setText("");
                return;
            } else if (mobileNo.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "MOBILE_NUMBER: cannot be empty:");
            } else if (mobileNo.length() > 10) {
                JOptionPane.showMessageDialog(rootPane, "Mobile number must be 10 digits:");
                mobileNoField.setText("");
            } else if (panCard.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "PAN_CARD: cannot be empty:");
            } else if (panCard.length() > 10) {
                JOptionPane.showMessageDialog(rootPane, "Pancard field can't be more than 10 digits:");
                panCardField.setText("");
            } else if (aadharCard.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "AADHAR_CARD: cannot be empty:");
            } else if (aadharCard.length() > 12) {
                JOptionPane.showMessageDialog(rootPane, "Aadhar Card filed must be 12 digits:");
                aadharcardField.setText("");
            } else {
                String userVerify = "select * from kyc_details where email_id='" + emailId + "' OR mobile_no = '" + mobileNo + "' OR user_pan_card = '" + panCard + "' OR user_aadhar_card ='" + aadharCard + "'";
                ResultSet resultSet = statement.executeQuery(userVerify);
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "User already exists !!!!\n" + "Recover your Account !!");
                    dispose();
                    new WelcomePage();
                    return;
                } // Now store all the text-field data into databse:
                else {
                    String user_details = "INSERT INTO user_details(username,name, email_id, mobile_no, password, login_type, user_aadhar_card) VALUES"
                            + " ('" + getUserName() + "', '" + customerName + "', '" + emailId + "', '" + mobileNo + "', '" + password + "', '" + login_type + "',  '" + aadharCard + "')";

                    String kyc_details = "INSERT INTO kyc_details ( user_aadhar_card, customer_first_name, customer_last_name, father_name, mother_name, user_dob,"
                            + " user_gender, user_martial_status, email_id, mobile_no, user_pan_card, username) VALUES "
                            + "('" + aadharCard + "', '" + firstName + "', '" + lastName + "', '" + fatherName + "', '" + motherName + "', '" + dob + "', '"
                            + gender + "', '" + martialStatus + "', '" + emailId + "', '" + mobileNo + "', '" + panCard + "', '" + getUserName() + "')";

                    /*    Debug SuccessFull:        
                    int rowsAffected = statement.executeUpdate(query1);
                    int rowsAffected2 = statement.executeUpdate(query2);
                    System.out.println("Rows affected user_details: " + rowsAffected);
                    System.out.println("Rows affected2 kyc_details: " + rowsAffected2); 
                     */
                    statement.executeUpdate(kyc_details);
                    statement.executeUpdate(user_details);
                }
                dispose();
                new AccountRegisterationSecond(userApplicationNumber, getUserName());
            }
        } catch (SQLException exception) {
            System.out.println("Exception is:\n" + exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void main(String[] args) {
        new AccountRegisteration();
    }
}

/*
  public ArrayList<String> user_details (){
    ArrayList<String> user_details = new ArrayList<>();
    user_details.add(0, firstNameField.getText().trim()+ lastNameField.getText().trim());
    user_details.add(1,getUserName());
    user_details.add(2, emailidField.getText().trim());    
    user_details.add(3, mobileNoField.getText().trim());    
    return user_details;
    }
    
    
    public ArrayList<String> kyc_details(){
    ArrayList<String> kyc_details = new ArrayList<>();
    kyc_details.add(0, firstNameField.getText().trim());
    kyc_details.add(1,lastNameField.getText().trim());
    kyc_details.add(2, fatherNameField.getText().trim());
    kyc_details.add(3, motherNameField.getText().trim());
    kyc_details.add(4, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
    kyc_details.add(5,getGender());
    kyc_details.add(6, getMartialStatus());
    kyc_details.add(7, emailidField.getText().trim());
    kyc_details.add(8, mobileNoField.getText().trim());
    kyc_details.add(0, panCardField.getText().trim());
    kyc_details.add(10, aadharcardField.getText().trim());
    kyc_details.add(11,getUserName());   
    return kyc_details;
    }  
   
    // Getting Data from the Form to store in Database:
//    public static CustomerForm user_details (){
//        return new CustomerForm(firstNameField.getText().trim() + lastNameField.getText().trim().toLowerCase(),
//                usernameField.getText().trim().toLowerCase(), emailidField.getText().toLowerCase().trim(),
//                mobileNoField.getText().trim());
//    }
    
//      public static ArrayList<CustomerForm> kyc_details (ArrayList<CustomerForm> user){
//        String fullName = firstNameField.getText().trim() + lastNameField.getText().trim();
//        CustomerForm customerForm = new CustomerForm(fullName.toLowerCase(), usernameField.getText().trim().toLowerCase(),
//                emailidField.getText().toLowerCase().trim(), mobileNoField.getText().trim());
//       user.add(customerForm);
//       return user;
//    }
    
    
    
   // Storing Data Locally using Collection( HashMap):
    public HashMap<String,String> userDetails(HashMap<String, String> users){
        this.users.put("applicationNumber",applicationNoField.getText().trim());
        this.users.put("username",getUserName().trim());
        this.users.put("firstName",firstNameField.getText().trim());
        this.users.put("lastName",lastNameField.getText().trim());
        this.users.put("fatherName", fatherNameField.getText().trim());
        this.users.put("motherName", motherNameField.getText().trim());
        this.users.put("dateOfBirth", ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
        this.users.put("gender",getGender());
        this.users.put("martialStatus",getMartialStatus());
        this.users.put("emailId",emailidField.getText().trim());
        this.users.put("mobileNo",mobileNoField.getText().trim());
        this.users.put("panCard",panCardField.getText().trim());
        this.users.put("aadharcard",aadharcardField.getText().trim());
        System.out.println("Inside of UserDetails- Method: 1/3");
        System.out.println(this.users);
        return this.users;
    }
    
    
// TextField Validation for taking only digits in mobileTextBox:
    private void mobileNoFieldKeyPresses(java.awt.event.KeyEvent evt){
        String mobileNumber = mobileNoField.getText().trim();
        int length = mobileNumber.length();
        char ch = evt.getKeyChar();
        // check for coming keyChar is from [ 0-9 ]
        if(evt.getKeyChar()>='0' && evt.getKeyChar() <= '9') {
            // first checking the pressed length not more than 10
            if (length < 10) {
                // Editable if length < 10
                mobileNoField.setEditable(true);
            } else {
                // Not-Editable if length > 10
                mobileNoField.setEditable(false);
            }
        }
         else
            {
                //Now allowing BackSpace/ Delete for edit the textField
                if(evt.getExtendedKeyCode()== KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()== KeyEvent.VK_DELETE){
                    mobileNoField.setEditable(true);
                }
                else{
                    mobileNoField.setEditable(false);
                }
            }
        }
 // Mobile-TextField Validation End Here:


 */
