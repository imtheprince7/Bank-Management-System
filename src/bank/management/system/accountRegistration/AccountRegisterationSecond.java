package bank.management.system.accountRegistration;

import bank.management.system.database.EmailOtpVerification;
import bank.management.system.database.DatabaseConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AccountRegisterationSecond extends JFrame implements ActionListener {

    String flateNo, streetNo, landmark, pinCode, disrict, city, state, country, getUserApplicationNumber, getuserName, accountNumber;
    JPanel mainPanel;
    JLabel ImageLabel, applicationNoLabel, flateNoLabel, streetLabel, landmarkLabel, pincodeLabel, districtLabel, cityLabel, stateLabel, countryLabel;
    JTextField applicationNoField, flateNoField, streetField, landmarkField, pincodeField, districtField, cityField, stateField, countryField;
    JButton nextButton, clearButton;

    private Connection connection;
    private Statement statement;

    public AccountRegisterationSecond(String userApplicationNumber, String userName) {
        getUserApplicationNumber = userApplicationNumber;
        getuserName = userName;
        accountNumber = EmailOtpVerification.getAccountNumber();

        setResizable(false);
        setLayout(null);
        setSize(900, 510);
        setLocation(200, 100);
        setTitle("Account Registration || Address Details (2/3)");

        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image img1 = img.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        ImageLabel = new JLabel(img2);
        mainPanel.add(ImageLabel);

        applicationNoLabel = new JLabel("Application Number");
        applicationNoField = new JTextField();
        applicationNoField.setEditable(false);
        applicationNoField.setText(getUserApplicationNumber);

        flateNoLabel = new JLabel("Flat No.");
        flateNoField = new JTextField();
        streetLabel = new JLabel("Street No");
        streetField = new JTextField();

        landmarkLabel = new JLabel("Landmark");
        landmarkField = new JTextField();
        pincodeLabel = new JLabel("Pincode");
        pincodeField = new JTextField();
        districtLabel = new JLabel("District");
        districtField = new JTextField();

        cityLabel = new JLabel("City");
        cityField = new JTextField();
        stateLabel = new JLabel("State");
        stateField = new JTextField();
        countryLabel = new JLabel("Country");
        countryField = new JTextField();
        countryField.setEditable(false);
        countryField.setText("INDIA");

        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);
        clearButton.setForeground(Color.red);
        nextButton = new JButton("NEXT");
        nextButton.addActionListener(this);

        setFont();
        setBound();
        addComponent();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setFont() {
        applicationNoLabel.setFont(new Font("verdana", Font.BOLD, 12));
        applicationNoField.setFont(new Font("verdana", Font.BOLD, 14));
        flateNoLabel.setFont(new Font("verdana", Font.BOLD, 14));
        flateNoField.setFont(new Font("verdana", Font.ITALIC, 15));
        streetLabel.setFont(new Font("verdana", Font.BOLD, 14));
        streetField.setFont(new Font("verdana", Font.ITALIC, 15));
        landmarkLabel.setFont(new Font("verdana", Font.BOLD, 14));
        landmarkField.setFont(new Font("verdana", Font.ITALIC, 15));
        pincodeLabel.setFont(new Font("verdana", Font.BOLD, 14));
        pincodeField.setFont(new Font("verdana", Font.ITALIC, 15));
        districtLabel.setFont(new Font("verdana", Font.BOLD, 14));
        districtField.setFont(new Font("verdana", Font.ITALIC, 15));
        cityLabel.setFont(new Font("verdana", Font.BOLD, 14));
        cityField.setFont(new Font("verdana", Font.ITALIC, 15));
        stateLabel.setFont(new Font("verdana", Font.BOLD, 14));
        stateField.setFont(new Font("verdana", Font.ITALIC, 15));
        countryLabel.setFont(new Font("verdana", Font.BOLD, 14));
        countryField.setFont(new Font("verdana", Font.ITALIC, 15));
    }

    public void setBound() {
        mainPanel.setBounds(0, 0, 900, 500);
        ImageLabel.setBounds(450, 0, 500, 100);
        applicationNoLabel.setBounds(20, 20, 200, 30);
        applicationNoField.setBounds(200, 20, 200, 40);
        flateNoLabel.setBounds(20, 70, 200, 40);
        flateNoField.setBounds(200, 70, 200, 40);
        streetLabel.setBounds(20, 120, 200, 40);
        streetField.setBounds(200, 120, 200, 40);
        landmarkLabel.setBounds(20, 170, 200, 40);
        landmarkField.setBounds(200, 170, 200, 40);
        pincodeLabel.setBounds(20, 220, 200, 40);
        pincodeField.setBounds(200, 220, 200, 40);
        districtLabel.setBounds(20, 270, 200, 40);
        districtField.setBounds(200, 270, 200, 40);
        cityLabel.setBounds(20, 320, 200, 40);
        cityField.setBounds(200, 320, 200, 40);
        stateLabel.setBounds(20, 370, 200, 40);
        stateField.setBounds(200, 370, 200, 40);
        countryLabel.setBounds(20, 420, 200, 40);
        countryField.setBounds(200, 420, 200, 40);
        clearButton.setBounds(600, 400, 100, 40);
        nextButton.setBounds(750, 400, 100, 40);
    }

    public void addComponent() {
        mainPanel.add(applicationNoLabel);
        mainPanel.add(applicationNoField);
        mainPanel.add(flateNoLabel);
        mainPanel.add(flateNoField);
        mainPanel.add(streetLabel);
        mainPanel.add(streetField);
        mainPanel.add(landmarkLabel);
        mainPanel.add(landmarkField);
        mainPanel.add(pincodeLabel);
        mainPanel.add(pincodeField);
        mainPanel.add(districtLabel);
        mainPanel.add(districtField);
        mainPanel.add(cityLabel);
        mainPanel.add(cityField);
        mainPanel.add(stateLabel);
        mainPanel.add(stateField);
        mainPanel.add(countryLabel);
        mainPanel.add(countryField);
        mainPanel.add(clearButton);
        mainPanel.add(nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // throw new UnsupportedOperationException("Not supported yet."); 

        if ("CLEAR".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to \n CLEAR ALL FIELDS ?\n", "CONFIRM",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                flateNoField.setText("");
                streetField.setText("");
                landmarkField.setText("");
                pincodeField.setText("");
                districtField.setText("");
                cityField.setText("");
                stateField.setText("");
                countryField.setText("");
            }
        }

        if ("NEXT".equals(event.getActionCommand())) {

            flateNo = flateNoField.getText().trim();
            streetNo = streetField.getText().trim();
            landmark = landmarkField.getText().trim();
            pinCode = pincodeField.getText().trim();
            disrict = districtField.getText().trim();
            city = cityField.getText().trim();
            state = stateField.getText().trim();
            country = countryField.getText().trim();

            try {
                // Validating and Storing all data into Database;
                saveDataIntoDatabase();
            } catch (SQLException | ClassNotFoundException exception) {
                Logger.getLogger(AccountRegisterationSecond.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }

    public void saveDataIntoDatabase() throws SQLException, ClassNotFoundException {
        connection = DatabaseConnection.ConnectionString();
        statement = connection.createStatement();
        try {
            // First checking textFields are not empty
            if (flateNo.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "FLAT_NO: cannot be empty:");
            } else if (flateNo.length() > 25) {
                JOptionPane.showMessageDialog(rootPane, "Flat number must be 10 digit: field can't have more than 25 characters:");
            } else if (streetNo.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "STREET_NO: cannot be empty:");
            } else if (streetNo.length() > 25) {
                JOptionPane.showMessageDialog(rootPane, "Street Number field can't have more than 25 characters:");
            } else if (landmark.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "LANDMARK: cannot be empty:");
            } else if (landmark.length() > 50) {
                JOptionPane.showMessageDialog(rootPane, "Landmarl field can't have more than 50 characters");
            } else if (pinCode.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "PINCODE: cannot be empty:");
            } else if (pinCode.length() > 6) {
                JOptionPane.showMessageDialog(rootPane, "Pin Code can't be more than 06 digits:");
            } else if (disrict.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "DISTRICT: cannot be empty:");
            } else if (disrict.length() > 20) {
                JOptionPane.showMessageDialog(rootPane, "District field can't have more than 20 characters:");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "CITY: cannot be empty:");
            } else if (city.length() > 20) {
                JOptionPane.showMessageDialog(rootPane, "City length can't more than 20:");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "CITY: cannot be empty:");
            } else if (state.length() > 20) {
                JOptionPane.showMessageDialog(rootPane, "State field can't have more than 20 characters:");
            } else {
                // Now store all data of text-field into databse:
                String permanent_address = "INSERT INTO permanent_address (flat_no, street_no, landmark, pin_code, district, city, state, country, account_number) VALUES"
                        + " ('" + flateNo + "', '" + streetNo + "', '" + landmark + "', '" + pinCode + "', '" + disrict + "',"
                        + " '" + city + "', '" + state + "', '" + country + "', '" + accountNumber + "')";
                String communication_details = "INSERT INTO communication_address (flat_no, street_no, landmark, pin_code, district, city, state, country, account_number) VALUES"
                        + " ('" + flateNo + "', '" + streetNo + "', '" + landmark + "', '" + pinCode + "', '" + disrict + "',"
                        + " '" + city + "', '" + state + "', '" + country + "', '" + accountNumber + "')";

                /*     Debug SuccessFull:                          
                    int rowsAffected = statement.executeUpdate(query1);
                    int rowsAffected2 = statement.executeUpdate(query2);
                    System.out.println("Rows affected: from AccountRegisteration Page-2" + rowsAffected); 
                    System.out.println("Rows affected: from AccountRegisteration Page-2" + rowsAffected2);
                 */
                statement.executeUpdate(permanent_address);
                statement.executeUpdate(communication_details);
                dispose();
                new AccountRegisterationThird(getUserApplicationNumber, getuserName);
            }
        } catch (SQLException exception) {
            System.out.println("Exception from Accoun-Registration Page-2: \n" + exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

}

/* 
        public HashMap<String,String> userDetails(HashMap<String, String> users){
        this.users.put("flateNumber", flateNoField.getText().trim());     this.users.put("streetNumber",streetField.getText().trim());
        this.users.put("landMark", landmarkField.getText().trim());       this.users.put("pinCode", pincodeField.getText().trim());
        this.users.put("district", districtField.getText().trim());       this.users.put("city", cityField.getText().trim());
        this.users.put("state", stateField.getText().trim());             this.users.put("country", countryField.getText().trim());
        System.out.println("Inside of UserDetails- Method: 2/3");
        System.out.println(this.users);
        return this.users;
    }
 */
