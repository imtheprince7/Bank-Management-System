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
import java.util.ArrayList;

public class MobileBanking extends JFrame implements ActionListener {

    JPanel mainPanel, facilityMesagepanel, facilityButtonPanel, operationPanelFirst, operationPanelThird,
            operationPanelForth;
    JLabel nameLabel, accountNoLabel, accountyNameLabel, accountTypeLabel, depositLabel, withdrawLabel, transferLabel, currentAmountLabel;
    JTextField currentAmountField, nameField, accountNumberField, accountyNameField, accountTypeField, depositText;
    JButton depositButton, depositSecondButton, withdrawButton, clearButton, fastCashButton, pinChangeButton, amountTransferButton, transferButton, miniStatementButton, exitButton, logoutButton;

// Creating connection and Statement globally:
    private Connection connection = DatabaseConnection.ConnectionString();
    private Statement statement;
    static String applicantName = "", accountNumber = "", accountBalance, accountType, current_amount, amount = "100000", minbalance = "0", amountDeposit = "0";
    
    Date date = new Date();
    int currentAmount, withdrawlAmount, transferAmount;
    ArrayList<String> arr = new ArrayList<>();

    public MobileBanking(String name) throws HeadlessException, ClassNotFoundException, SQLException {
        this.applicantName = name;
        setTitle("MOBILE BANKING WINDOW");
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
        operationPanelFirst.setBackground(Color.GRAY);
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
        withdrawLabel = new JLabel("Enter Amount to withdraw from your account");
        transferLabel = new JLabel("Enter Amount to transfer from your account");
        depositSecondButton = new JButton("DEPOSIT AMOUNT");
        depositSecondButton.addActionListener(this);
        withdrawButton = new JButton("WITHDRAW AMOUNT");
        withdrawButton.addActionListener(this);
        transferButton = new JButton("TRANSFER AMOUNT");
        transferButton.addActionListener(this);
        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);

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
        mainPanel.add(facilityMesagepanel.add(operationPanelThird));
        mainPanel.add(facilityMesagepanel.add(operationPanelForth));

        operationPanelFirst.add(currentAmountLabel);
        operationPanelFirst.add(currentAmountField);
        operationPanelFirst.add(accountNoLabel);
        operationPanelFirst.add(accountNumberField);
        operationPanelFirst.add(accountyNameLabel);
        operationPanelFirst.add(accountyNameField);
        operationPanelFirst.add(accountTypeLabel);
        operationPanelFirst.add(accountTypeField);
        operationPanelFirst.add(depositLabel);
        operationPanelFirst.add(withdrawLabel);
        operationPanelFirst.add(transferLabel);
        operationPanelFirst.add(depositText);
        operationPanelFirst.add(depositSecondButton);
        operationPanelFirst.add(withdrawButton);
        operationPanelFirst.add(transferButton);
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
        withdrawLabel.setFont(new Font("verdana", Font.BOLD, 14));
        transferLabel.setFont(new Font("verdana", Font.BOLD, 14));
        depositText.setFont(new Font("verdana", Font.BOLD, 15));
        depositSecondButton.setFont(new Font("verdana", Font.BOLD, 15));
        withdrawButton.setFont(new Font("verdana", Font.BOLD, 13));
        transferButton.setFont(new Font("verdana", Font.BOLD, 13));
        clearButton.setFont(new Font("verdana", Font.BOLD, 14));
    }

    public void setBound() {
        mainPanel.setBounds(0, 0, 800, 600);
        facilityMesagepanel.setBounds(0, 70, 600, 530);
        facilityButtonPanel.setBounds(600, 70, 200, 530);
        operationPanelFirst.setBounds(0, 70, 600, 530);
        operationPanelThird.setBounds(0, 70, 600, 530);
        operationPanelForth.setBounds(0, 70, 600, 530);
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
        withdrawLabel.setBounds(10, 250, 400, 40);
        transferLabel.setBounds(10, 250, 400, 40);
        depositText.setBounds(400, 250, 100, 40);
        depositSecondButton.setBounds(250, 350, 200, 40);
        withdrawButton.setBounds(250, 350, 220, 40);
        transferButton.setBounds(250, 350, 220, 40);
        clearButton.setBounds(480, 350, 120, 40);

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
            operationPanelThird.setVisible(false);
            operationPanelForth.setVisible(false);
            withdrawButton.setVisible(false);
            withdrawLabel.setVisible(false);
            transferLabel.setVisible(false);
            transferButton.setVisible(false);
            depositSecondButton.setVisible(true);
            depositLabel.setVisible(true);

        }
        if ("DEPOSIT AMOUNT".equals(event.getActionCommand())) {
            if (depositText.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "You can't leave blank deposit section:");
            } else if (depositText.getText().length() > 6) {
                JOptionPane.showMessageDialog(rootPane, "You can only deposit upto 1 Lack:");
                depositText.setText("");
            } else if (depositText.getText().equals(minbalance)) {
                JOptionPane.showMessageDialog(rootPane, "You can't deposit 000 amount::");
            } else {
                try {
                    accountNumber = getAccountDetails().get(1);
                    accountType = getAccountDetails().get(2);
                    String amount_withdrawal = "0", amountDeposit = depositText.getText().trim();
                    int totalAmount = Integer.parseInt(currentAmountField.getText().trim()) + Integer.parseInt(amountDeposit);
                    current_amount = Integer.toString(totalAmount);

                    statement = connection.createStatement();
                    String updateAmount = "UPDATE deposit_details SET account_type = '" + accountType + "', "
                            + "date = '" + date + "', "
                            + "amount_deposit = '" + amountDeposit + "', "
                            + "amount_withdrawal = '" + amount_withdrawal + "', "
                            + "current_amount = '" + current_amount + "' "
                            + "WHERE account_number = '" + accountNumber + "'";
                    int rowsAffected = statement.executeUpdate(updateAmount);
                    if (rowsAffected == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Your amount" + " " + amountDeposit + " " + "has been deposited:");
                        depositText.setText("");
                        currentAmountField.setText(getCurrentAmount());
                        depositSecondButton.setForeground(Color.BLUE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Your amount" + " " + amountDeposit + " " + "has not been deposited:");
                        depositText.setText("");
                        currentAmountField.setText(getCurrentAmount());
                        depositSecondButton.setForeground(Color.RED);
                    }
                } catch (ClassNotFoundException | SQLException exception) {
                    Logger.getLogger(MobileBanking.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
        if ("FAST CASH".equals(event.getActionCommand())) {
            facilityMesagepanel.setVisible(false);
            operationPanelFirst.setVisible(true);
            operationPanelThird.setVisible(false);
            operationPanelForth.setVisible(false);

            depositSecondButton.setVisible(false);
            depositLabel.setVisible(false);
            transferLabel.setVisible(false);
            withdrawButton.setVisible(true);
            withdrawLabel.setVisible(true);
            transferButton.setVisible(false);
        }

        if ("WITHDRAW AMOUNT".equals(event.getActionCommand())) {
            if (depositText.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "You can't leave blank withdrawl section:");
            } else if (depositText.getText().length() > 6) {
                JOptionPane.showMessageDialog(rootPane, "You can only withdrawl upto 1 Lack:");
                depositText.setText("");
            } else if (depositText.getText().equals(minbalance)) {
                JOptionPane.showMessageDialog(rootPane, "You can't withdrawl 000 amount::");
            } else {
                try {
                    if (checkMinimumBalance() == false) {
                        accountNumber = getAccountDetails().get(1);
                        accountType = getAccountDetails().get(2);
                        withdrawlAmount = Integer.parseInt(depositText.getText().trim());
                        currentAmount = currentAmount - withdrawlAmount;
                        String withdrawAmount = "UPDATE deposit_details SET account_type = '" + accountType + "', "
                                + "date = '" + date + "', "
                                + "amount_deposit = '" + amountDeposit + "', "
                                + "amount_withdrawal = '" + withdrawlAmount + "', "
                                + "current_amount = '" + currentAmount + "' "
                                + "WHERE account_number = '" + accountNumber + "'";
                        int rowsAffected = statement.executeUpdate(withdrawAmount);
                        if (rowsAffected == 1) {
                            JOptionPane.showMessageDialog(rootPane, "Withdrawal amount " + " " + withdrawlAmount + " " + "has been withdrawl:");
                            depositText.setText("");
                            currentAmountField.setText(getCurrentAmount());
                            withdrawButton.setForeground(Color.GREEN);
                        }
                    }
                } catch (ClassNotFoundException | SQLException exception) {
                    Logger.getLogger(MobileBanking.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
        if ("PIN CHANGE".equals(event.getActionCommand())) {
            facilityMesagepanel.setVisible(false);
            operationPanelFirst.setVisible(false);
            operationPanelThird.setVisible(true);
            operationPanelForth.setVisible(false);

        }

        if ("AMOUNT TRANSFER".equals(event.getActionCommand())) {
            facilityMesagepanel.setVisible(false);
            operationPanelFirst.setVisible(true);
            operationPanelThird.setVisible(false);
            operationPanelForth.setVisible(true);
            depositSecondButton.setVisible(false);
            depositLabel.setVisible(false);
            withdrawButton.setVisible(false);
            withdrawLabel.setVisible(false);
            transferLabel.setVisible(true);
            transferButton.setVisible(true);
//            accountyNameField.setText(""); 
//            accountNumberField.setText("");
//            accountTypeField.setText("");   
        }

        if ("TRANSFER AMOUNT".equals(event.getActionCommand())) {
            
            if (depositText.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "You can't leave blank TRANSFER AMOUNT section:");
            } else if (depositText.getText().length() > 6) {
                JOptionPane.showMessageDialog(rootPane, "You can only TRANSFER upto 1 Lack:");
                depositText.setText("");
            } else if (depositText.getText().equals(minbalance)) {
                JOptionPane.showMessageDialog(rootPane, "You can't TRANSFER 000 amount::");
            } else if (accountyNameField.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "You can't leave Accounty Name Field:");
            } else if (accountNumberField.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "You can't leave Account Number Field:");
            } else if (accountTypeField.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "You can't leave Account Type   Field:");
            } else {
                try {
                    if (checkMinimumBalance() == false) {
                        statement = connection.createStatement();
                        accountNumber = accountNumberField.getText();
                        accountType = accountTypeField.getText();
                        transferAmount = Integer.parseInt(depositText.getText().trim());
                        currentAmount = currentAmount - transferAmount;                        
    // TransferAmount in sender account Query:    
                        String transferAmount = "UPDATE deposit_details SET account_type = '" + accountType + "', "
                                + "date = '" + date + "', "
                                + "amount_deposit = '" + amountDeposit + "', "
                                + "amount_withdrawal = '" + withdrawlAmount + "', "
                                + "current_amount = '" + currentAmount + "' "
                                + "WHERE account_number = '" + accountNumber + "'";
                        int rowsAffected = statement.executeUpdate(transferAmount);
                        if (rowsAffected == 1) {
                            JOptionPane.showMessageDialog(rootPane, "Amount " + " " + transferAmount + " " + "has been Transferred:");
                            depositText.setText("");
                            currentAmountField.setText(getCurrentAmount());
                            transferButton.setForeground(Color.GREEN);
                        }
                        String account_number = getAccountDetails().get(1), account_type = getAccountDetails().get(2);
                        int withdrawl_amount = Integer.parseInt(depositText.getText().trim());
                        currentAmount = currentAmount - withdrawl_amount;
    // Withdrawl Amount from sendi account Query:    
                        String withdrawlQuery = "UPDATE deposit_details SET account_type = '" + account_type + "', "
                                + "date = '" + date + "', "
                                + "amount_deposit = '" + amountDeposit + "', "
                                + "amount_withdrawal = '" + withdrawl_amount + "', "
                                + "current_amount = '" + currentAmount + "' "
                                + "WHERE account_number = '" + account_number + "'";
                        int rowsAffected2 = statement.executeUpdate(withdrawlQuery);
                        if (rowsAffected2 == 1) {
                            JOptionPane.showMessageDialog(rootPane, "Amount " + " " + withdrawl_amount + " " + "has been Transferred:");
                            depositText.setText("");
                            currentAmountField.setText(getCurrentAmount());
                            transferButton.setForeground(Color.GREEN);
                        }
                    }
                } catch (ClassNotFoundException | SQLException exception) {
                    Logger.getLogger(MobileBanking.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }

        if ("MINI STATEMENT".equals(event.getActionCommand())) {
            facilityMesagepanel.setVisible(false);
            operationPanelFirst.setVisible(false);
            operationPanelThird.setVisible(false);
            operationPanelForth.setVisible(false);

        }

        if ("CLEAR".equals(event.getActionCommand())) {
            depositText.setText("");
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

    public boolean checkMinimumBalance() throws ClassNotFoundException, SQLException {
        boolean checkWithdrawl = false;
        Date date = new Date();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from deposit_details where account_type='" + accountType + "'"
                    + " AND account_number='" + accountNumber + "'");
            if (resultSet.next()) {
                currentAmount = Integer.parseInt(resultSet.getString("current_amount"));
            }
            if (currentAmount < Integer.parseInt(depositText.getText().trim())) {
                checkWithdrawl = true;
                JOptionPane.showMessageDialog(rootPane, "Withdrawal Amount is High \n Your amount" + " " + withdrawlAmount + " " + "cannot be Initiated:");
                depositText.setText("");
                currentAmountField.setText(getCurrentAmount());
                withdrawButton.setForeground(Color.RED);
                return checkWithdrawl;
            }
        } catch (ClassNotFoundException | SQLException exception) {
            Logger.getLogger(MobileBanking.class.getName()).log(Level.SEVERE, null, exception);
        }
        return checkWithdrawl;
    }
}
