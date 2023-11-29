package bank.management.system.bankfacility;

import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.database.DatabaseConnection;
import static bank.management.system.database.MysqlJoinsClasses.*;
import java.util.Date;
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
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileBanking extends JFrame implements ActionListener {

    JPanel mainPanel, facilityMesagepanel, facilityButtonPanel, operationPanelFirst, operationPanelSecond, operationPanelThird,
            operationPanelForth, operationPanelFifth;
    JLabel nameLabel, accountNoLabel, accountyNameLabel, accountTypeLabel, depositLabel, currentAmountLabel;
    JTextField currentAmountField, nameField, accountNumberField, accountyNameField, accountTypeField, depositText;
    JButton depositButton, depositSecondButton, clearButton, fastCashButton, pinChangeButton, amountTransferButton, miniStatementButton, exitButton, logoutButton;
// Creating connection and Statement globally:
    private Connection connection;
    private Statement statement;
    static String applicantName = "", accountNumber, accountyName, accountType;

    public MobileBanking(String name) throws HeadlessException, ClassNotFoundException, SQLException {
        this.applicantName = name;
        setTitle("Common Banking Facilities");
        setLayout(null);
        setResizable(false);
        setSize(800, 600);
        setLocation(350, 150);

        mainPanel = new JPanel();
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
        nameField.setText("Prince Kumar");

        depositButton = new JButton("DEPOSIT");
        depositButton.addActionListener(this);
        fastCashButton = new JButton("FAST CASH");
        fastCashButton.addActionListener(this);

        pinChangeButton = new JButton("PIN CHANGE");
        pinChangeButton.addActionListener(this);
        amountTransferButton = new JButton("AMOUNT TRANSFER");
        amountTransferButton.addActionListener(this);

        miniStatementButton = new JButton("MINI STATEMENT");
        miniStatementButton.addActionListener(this);
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);
        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(this);

        operationPanelFirst = new JPanel();
        add(operationPanelFirst);
        operationPanelFirst.setBackground(Color.pink);
        operationPanelFirst.setLayout(null);
        operationPanelFirst.setVisible(false);

        currentAmountLabel = new JLabel("Current Amount");
        currentAmountField = new JTextField();
        currentAmountField.setEditable(false);
        currentAmountField.setText(getCurrentAmount());
        accountNoLabel = new JLabel("Account Number");
        accountNumberField = new JTextField();
        accountNumberField.setEditable(false);
        accountNumberField.setText(getAccountDetails().get(1));
        accountyNameLabel = new JLabel("Name");
        accountyNameField = new JTextField();
        accountyNameField.setEditable(false);
        accountyNameField.setText(getAccountDetails().get(0));
        accountTypeLabel = new JLabel("Account Type");
        accountTypeField = new JTextField();
        accountTypeField.setEditable(false);
        accountTypeField.setText(getAccountDetails().get(2));
        depositLabel = new JLabel("Enter Amount to deposit in your account");
        depositText = new JTextField();

        depositSecondButton = new JButton("DEPOSIT AMOUNT");
        depositSecondButton.addActionListener(this);
        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);

        operationPanelSecond = new JPanel();
        add(operationPanelSecond);
        operationPanelSecond.setBackground(Color.BLUE);
        operationPanelSecond.setLayout(null);
        operationPanelSecond.setVisible(false);

        operationPanelThird = new JPanel();
        add(operationPanelThird);
        operationPanelThird.setBackground(Color.DARK_GRAY);
        operationPanelThird.setLayout(null);
        operationPanelThird.setVisible(false);

        operationPanelForth = new JPanel();
        add(operationPanelForth);
        operationPanelForth.setBackground(Color.MAGENTA);
        operationPanelForth.setLayout(null);
        operationPanelForth.setVisible(false);

        operationPanelFifth = new JPanel();
        add(operationPanelFifth);
        operationPanelFifth.setBackground(Color.ORANGE);
        operationPanelFifth.setLayout(null);
        operationPanelFifth.setVisible(false);

        addComponent();
        setBound();
        setFont();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addComponent() {
        mainPanel.add(logoutButton);
        mainPanel.add(facilityMesagepanel);
        mainPanel.add(facilityButtonPanel);
        mainPanel.add(facilityMesagepanel.add(nameLabel));
        mainPanel.add(facilityMesagepanel.add(nameField));
        mainPanel.add(facilityButtonPanel.add(depositButton));
        mainPanel.add(facilityButtonPanel.add(fastCashButton));
        mainPanel.add(facilityButtonPanel.add(pinChangeButton));
        mainPanel.add(facilityButtonPanel.add(amountTransferButton));
        mainPanel.add(facilityButtonPanel.add(miniStatementButton));
        mainPanel.add(facilityButtonPanel.add(exitButton));
        mainPanel.add(facilityMesagepanel.add(operationPanelFirst));
        mainPanel.add(facilityMesagepanel.add(operationPanelSecond));
        mainPanel.add(facilityMesagepanel.add(operationPanelThird));
        mainPanel.add(facilityMesagepanel.add(operationPanelForth));
        mainPanel.add(facilityMesagepanel.add(operationPanelFifth));

        operationPanelFirst.add(currentAmountLabel);
        operationPanelFirst.add(currentAmountField);
        operationPanelFirst.add(accountNoLabel);
        operationPanelFirst.add(accountNumberField);
        operationPanelFirst.add(accountyNameLabel);
        operationPanelFirst.add(accountyNameField);
        operationPanelFirst.add(accountTypeLabel);
        operationPanelFirst.add(accountTypeField);
        operationPanelFirst.add(depositLabel);
        operationPanelFirst.add(depositText);
        operationPanelFirst.add(depositSecondButton);
        operationPanelFirst.add(clearButton);

    }

    public void setFont() {
        nameLabel.setFont(new Font("verdana", Font.BOLD, 18));
        nameField.setFont(new Font("verdana", Font.BOLD, 16));
        depositButton.setFont(new Font("verdana", Font.BOLD, 13));
        fastCashButton.setFont(new Font("verdana", Font.BOLD, 13));
        pinChangeButton.setFont(new Font("verdana", Font.BOLD, 13));
        miniStatementButton.setFont(new Font("verdana", Font.BOLD, 13));
        amountTransferButton.setFont(new Font("verdana", Font.BOLD, 12));
        exitButton.setFont(new Font("verdana", Font.BOLD, 15));
        logoutButton.setFont(new Font("verdana", Font.BOLD, 15));
        currentAmountLabel.setFont(new Font("verdana", Font.BOLD, 15));
        currentAmountField.setFont(new Font("verdana", Font.BOLD, 15));
        accountyNameLabel.setFont(new Font("verdana", Font.BOLD, 15));
        accountyNameField.setFont(new Font("verdana", Font.BOLD, 15));
        accountNoLabel.setFont(new Font("verdana", Font.BOLD, 15));
        accountNumberField.setFont(new Font("verdana", Font.BOLD, 15));
        accountTypeLabel.setFont(new Font("verdana", Font.BOLD, 15));
        accountTypeField.setFont(new Font("verdana", Font.BOLD, 15));
        depositLabel.setFont(new Font("verdana", Font.BOLD, 15));
        depositText.setFont(new Font("verdana", Font.BOLD, 15));
        depositSecondButton.setFont(new Font("verdana", Font.BOLD, 15));
        clearButton.setFont(new Font("verdana", Font.BOLD, 15));
    }

    public void setBound() {
        mainPanel.setBounds(0, 0, 800, 600);
        facilityMesagepanel.setBounds(0, 70, 600, 530);
        facilityButtonPanel.setBounds(600, 70, 200, 530);
        operationPanelFirst.setBounds(0, 70, 600, 530);
        operationPanelSecond.setBounds(0, 70, 600, 530);
        operationPanelThird.setBounds(0, 70, 600, 530);
        operationPanelForth.setBounds(0, 70, 600, 530);
        operationPanelFifth.setBounds(0, 70, 600, 530);
        nameLabel.setBounds(10, 10, 200, 40);
        nameField.setBounds(80, 10, 250, 40);

        depositButton.setBounds(620, 200, 150, 40);
        fastCashButton.setBounds(620, 260, 150, 40);
        pinChangeButton.setBounds(620, 320, 150, 40);
        miniStatementButton.setBounds(610, 380, 170, 40);
        amountTransferButton.setBounds(610, 440, 170, 40);
        exitButton.setBounds(610, 500, 170, 40);
        logoutButton.setBounds(650, 5, 130, 40);

        currentAmountLabel.setBounds(10, 50, 150, 40);
        currentAmountField.setBounds(250, 50, 150, 40);
        accountyNameLabel.setBounds(10, 100, 150, 40);
        accountyNameField.setBounds(250, 100, 250, 40);
        accountNoLabel.setBounds(10, 150, 150, 40);
        accountNumberField.setBounds(250, 150, 250, 40);
        accountTypeLabel.setBounds(10, 200, 150, 40);
        accountTypeField.setBounds(250, 200, 250, 40);
        depositLabel.setBounds(10, 250, 400, 40);
        depositText.setBounds(400, 250, 100, 40);
        depositSecondButton.setBounds(250, 350, 200, 40);
        clearButton.setBounds(460, 350, 130, 40);

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

        if ("DEPOSIT".equals(event.getActionCommand())) {
            operationPanelFirst.setVisible(true);
            facilityMesagepanel.setVisible(false);
            operationPanelSecond.setVisible(false);
            operationPanelThird.setVisible(false);
            operationPanelForth.setVisible(false);
            operationPanelFifth.setVisible(false);

        }
        if ("DEPOSIT AMOUNT".equals(event.getActionCommand())) {
            String amount = "100000", minbalance = "0";
            if (depositText.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "You can't leave blank deposit section:");
            } else if (depositText.getText().length() > 6) {
                JOptionPane.showMessageDialog(rootPane, "You can only deposit upto 1 Lack:");
                depositText.setText("");
            } else if (depositText.getText().equals(minbalance)) {
                JOptionPane.showMessageDialog(rootPane, "You can't deposit 000 amount::");
            } else {
                Date date = new Date();
                try {
                    String accountNumber = getAccountDetails().get(1), accountType = getAccountDetails().get(2), amount_withdrawal = "0", amountDeposit = depositText.getText().trim(); 
                    int totalAmount = Integer.parseInt(currentAmountField.getText().trim()) + Integer.parseInt(amountDeposit);
                    String cuurent_amount = Integer.toString(totalAmount);     
                    Connection connection = DatabaseConnection.ConnectionString();
                    Statement statement = connection.createStatement();
                    
                   String updateAmount = "UPDATE deposit_details SET account_type = '" + accountType + "', "
                        + "date = '" + date + "', " 
                        + "amount_deposit = '" + amountDeposit + "', "
                        + "amount_withdrawal = '" + amount_withdrawal + "', "
                        + "current_amount = '" + cuurent_amount + "' "
                        + "WHERE account_number = '" + accountNumber + "'";
                   int rowsAffected = statement.executeUpdate(updateAmount);
                    if(rowsAffected == 1){
                          JOptionPane.showMessageDialog(rootPane, "Your amount"+" "+amountDeposit+" "+"has been deposited:");
                          depositText.setText("");
                          currentAmountField.setText(getCurrentAmount());
                          depositSecondButton.setForeground(Color.BLUE);
                    }else{
                          JOptionPane.showMessageDialog(rootPane, "Your amount"+" "+amountDeposit+" "+"has not been deposited:");
                          depositText.setText("");
                          currentAmountField.setText(getCurrentAmount());
                          depositSecondButton.setForeground(Color.RED);
                    }
                } catch (ClassNotFoundException | SQLException exception) {
                    Logger.getLogger(MobileBanking.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
        if ("CLEAR".equals(event.getActionCommand())) {
            depositText.setText("");
        }

        if ("FAST CASH".equals(event.getActionCommand())) {
            facilityMesagepanel.setVisible(false);
            operationPanelSecond.setVisible(true);
            operationPanelFirst.setVisible(false);
            operationPanelThird.setVisible(false);
            operationPanelForth.setVisible(false);
            operationPanelFifth.setVisible(false);
        }

        if ("PIN CHANGE".equals(event.getActionCommand())) {
            facilityMesagepanel.setVisible(false);
            operationPanelFirst.setVisible(false);
            operationPanelSecond.setVisible(false);
            operationPanelThird.setVisible(true);
            operationPanelForth.setVisible(false);
            operationPanelFifth.setVisible(false);

        }

        if ("AMOUNT TRANSFER".equals(event.getActionCommand())) {
            facilityMesagepanel.setVisible(false);
            operationPanelFirst.setVisible(false);
            operationPanelSecond.setVisible(false);
            operationPanelThird.setVisible(false);
            operationPanelForth.setVisible(true);
            operationPanelFifth.setVisible(false);

        }

        if ("MINI STATEMENT".equals(event.getActionCommand())) {
            facilityMesagepanel.setVisible(false);
            operationPanelFirst.setVisible(false);
            operationPanelSecond.setVisible(false);
            operationPanelThird.setVisible(false);
            operationPanelForth.setVisible(false);
            operationPanelFifth.setVisible(true);

        }

        if ("EXIT".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to EXIT ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new ChooseFacility(applicantName);
            }
        }
    }

    public static void main(String[] args) throws HeadlessException, ClassNotFoundException, SQLException {
        new MobileBanking("Prince Kumar");
    }

    // getting Name of logged in userName:
}
