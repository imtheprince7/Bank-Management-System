package bank.management.system.accountRegistration;

import bank.management.system.accountRegistration.WelcomePage;
import bank.management.system.database.DatabaseConnection;
import bank.management.system.database.EmailOtpVerification;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccountRegisterationThird extends JFrame implements ActionListener{

     String userAccountNumber,ifscCode,micrCode,accountType,netBanking,mobileBanking, chequeBook, atmCard,
             getUserApplicationNumber, getuserName, password;
     JPanel mainPanel;
     JLabel applicationNoLabel, accountNumberLabel, ifscCodeLabel, micrCodeLabel, serviceLabel,netbankingLabel,
             mobileBankingLabel, chequeBookLabel, atmCardLabel, accountTypeLabel;
     JTextField applicationNoField, accountNumberField, ifscCodeField, micrCodeField;
     JRadioButton savingButton, currentButton, netbankingYes, netbankingNo, mobileBankingYes, mobileBankingNo,
                  chequeBook25, chequeBook50,chequeBook100,chequeBookNo, atmCardYes,atmCardNo ;
     ButtonGroup accountTypeGroup, netbankingGroup , mobileBankingGroup, chequeBookGroup, atmCardGroup;
     JButton clearButton, submitButton;
     static String accountNumber, ifsccodes = "CEGB3147000",micrcodes = "110015317",atmNumber,cvv ;     
     private Connection connection;
     private Statement statement;
    
     public AccountRegisterationThird( String userApplicationNumber, String userName ){
       
        getUserApplicationNumber = userApplicationNumber;
        getuserName = userName;
        password = AccountRegisteration.getPassword();
        accountNumber = EmailOtpVerification.getAccountNumber();
        atmNumber = EmailOtpVerification.getAtmNumber();
        cvv =  EmailOtpVerification.getCVVNumber();
        
        setTitle("Account Registration || Account Type (3/3)");
        setLayout(null);
        setResizable(false);
        setSize(900,550);
        setLocation(300,150);
        
        mainPanel= new JPanel();
        mainPanel.setBounds(0, 0,900,500);
        add(mainPanel);  
        mainPanel.setLayout(null);        
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image img1 = img.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        JLabel Imagelabel = new JLabel(img2);
        Imagelabel.setBounds(420, 0, 500, 100);
        
        
        mainPanel.add(Imagelabel);
        applicationNoLabel = new JLabel("Application Number");
        applicationNoField = new JTextField();
        applicationNoField.setEditable(false); 
        applicationNoField.setText(getUserApplicationNumber);
        
        accountNumberLabel = new JLabel("Account Number");       
        accountNumberField = new JTextField();  
        accountNumberField.setEditable(false); 
        accountNumberField.setText(accountNumber);       
        ifscCodeLabel = new JLabel("IFSC Code");
        ifscCodeField = new JTextField();
        ifscCodeField.setEditable(false); 
        ifscCodeField.setText(ifsccodes);

        micrCodeLabel = new JLabel("MICR Code");        
        micrCodeField = new JTextField();
        micrCodeField.setEditable(false); 
        micrCodeField.setText(micrcodes);

        serviceLabel = new JLabel("Services for Best Banking facilities");
        accountTypeLabel = new JLabel("Account Type");
        savingButton = new JRadioButton("Saving",true);
        currentButton = new JRadioButton("Current");
        accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(this.savingButton);
        accountTypeGroup.add(currentButton);

        netbankingLabel= new JLabel("Net Banking");       
        netbankingYes = new JRadioButton("YES");
        netbankingNo = new JRadioButton("NO", true);
        netbankingGroup = new ButtonGroup();
        netbankingGroup.add(this.netbankingYes);
        netbankingGroup.add(this.netbankingNo);
        
        mobileBankingLabel = new JLabel("Mobile Banking");
        mobileBankingYes = new JRadioButton("YES", true);
        mobileBankingNo = new JRadioButton("NO");
        mobileBankingGroup= new ButtonGroup();
        mobileBankingGroup.add(this.mobileBankingYes);
        mobileBankingGroup.add(this.mobileBankingNo);
        
        chequeBookLabel = new JLabel("Cheque Book");
        chequeBook25 = new JRadioButton("25 pages", true);
        chequeBook50 = new JRadioButton("50 pages");
        chequeBook100 = new JRadioButton("100 pages");
        chequeBookNo = new JRadioButton("NO");
        chequeBookGroup = new ButtonGroup();
        chequeBookGroup.add(this.chequeBook25);
        chequeBookGroup.add(this.chequeBook50);
        chequeBookGroup.add(this.chequeBook100);
        chequeBookGroup.add(this.chequeBookNo);
       
        atmCardLabel = new JLabel("ATM Card");
        atmCardYes = new JRadioButton("YES",true);      
        atmCardNo = new JRadioButton("NO");
        atmCardGroup = new ButtonGroup();
        atmCardGroup.add(this.atmCardYes);
        atmCardGroup.add(this.atmCardNo);
        
        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);
        clearButton.setForeground(Color.red);
        submitButton= new JButton("SUBMIT");
        submitButton.addActionListener(this);
                
        addComponent();
        setBound();
        setFont();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
    }
    
    public void setFont(){
        applicationNoLabel.setFont(new Font("verdana", Font.BOLD, 12)); 
        applicationNoField.setFont(new Font("verdana", Font.BOLD, 14));
        accountNumberLabel.setFont(new Font("verdana", Font.BOLD, 12));
        accountNumberField.setFont(new Font("verdana", Font.BOLD, 12));
        ifscCodeField.setFont(new Font("verdana", Font.BOLD, 12));   
        micrCodeField.setFont(new Font("verdana", Font.BOLD, 12));
        ifscCodeLabel.setFont(new Font("verdana", Font.BOLD, 12));  
        micrCodeLabel.setFont(new Font("verdana", Font.BOLD, 12));
        serviceLabel.setFont(new Font("verdana", Font.BOLD, 14));  
        accountTypeLabel.setFont(new Font("verdana", Font.BOLD, 12));
        netbankingLabel.setFont(new Font("verdana", Font.BOLD, 12)); 
        mobileBankingLabel.setFont(new Font("verdana", Font.BOLD, 12));
        chequeBookLabel.setFont(new Font("verdana", Font.BOLD, 12));   
        atmCardLabel.setFont(new Font("verdana", Font.BOLD, 12));
        clearButton.setFont(new Font("verdana", Font.BOLD, 12));
        submitButton.setFont(new Font("verdana", Font.BOLD, 12));
    }
    
    public void setBound(){
        applicationNoLabel.setBounds(20, 20, 200, 30);  
        applicationNoField.setBounds(200, 20, 200, 30);
        accountNumberLabel.setBounds(20, 60, 200, 30); 
        accountNumberField.setBounds(200, 60, 200, 30);
        ifscCodeLabel.setBounds(20, 100, 200, 30);   
        ifscCodeField.setBounds(200, 100, 200, 30);
        micrCodeLabel.setBounds(20, 140, 200, 30); 
        micrCodeField.setBounds(200, 140, 200, 30);

        serviceLabel.setBounds(20, 190, 350, 30);   
        accountTypeLabel.setBounds(20, 230, 200, 30);
        savingButton.setBounds(200, 230, 200, 30); 
        currentButton.setBounds(400, 230, 200, 30);
        netbankingLabel.setBounds(20, 270, 200, 30); 
        netbankingYes.setBounds(200, 270, 80, 30);
        netbankingNo.setBounds(300, 270, 100, 30); 
        mobileBankingLabel.setBounds(20, 310, 200, 30);
        mobileBankingYes.setBounds(200, 310, 80, 30);   
        mobileBankingNo.setBounds(300, 310, 100, 30);
        chequeBookLabel.setBounds(20, 350, 200, 30);
        chequeBook25.setBounds(200, 350, 100, 30);
        chequeBook50.setBounds(350, 350, 100, 30);  
        chequeBook100.setBounds(500, 350, 100, 30);
        chequeBookNo.setBounds(650, 350, 100, 30); 
        atmCardLabel.setBounds(20, 390, 100, 30);
        atmCardYes.setBounds(200, 390, 100, 30); 
        atmCardNo.setBounds(350, 390, 100, 30);
        clearButton.setBounds(630, 450, 100, 40);
        submitButton.setBounds(760, 450, 100, 40);
    }
    
    public  void addComponent(){
        mainPanel.add(applicationNoLabel);
        mainPanel.add(applicationNoField);
        mainPanel.add(accountNumberLabel); 
        mainPanel.add(accountNumberField);
        mainPanel.add(ifscCodeLabel);    
        mainPanel.add(ifscCodeField);
        mainPanel.add(micrCodeLabel);      
        mainPanel.add(micrCodeField);
        mainPanel.add(serviceLabel);  
        mainPanel.add(accountTypeLabel);
        mainPanel.add(savingButton);   
        mainPanel.add(currentButton);
        mainPanel.add(netbankingLabel);   
        mainPanel.add(netbankingYes);
        mainPanel.add(netbankingNo);     
        mainPanel.add(mobileBankingLabel);
        mainPanel.add(mobileBankingYes); 
        mainPanel.add(mobileBankingNo);
        mainPanel.add(chequeBookLabel);   
        mainPanel.add(chequeBook25);
        mainPanel.add(chequeBook50);      
        mainPanel.add(chequeBook100);
        mainPanel.add(chequeBookNo);     
        mainPanel.add(atmCardLabel);
        mainPanel.add(atmCardYes);       
        mainPanel.add(atmCardNo);
        mainPanel.add(clearButton);      
        mainPanel.add(submitButton);
    }
    
   
  // Method to get data from Better-Service-Facilities:
     public String getAccountType(){
        String accountType=null;
        if(savingButton.isSelected())
            accountType = "SAVING";
        else if( currentButton.isSelected())
                accountType = "CURRENT";
        return accountType;
       }     
      public String getNetBanking(){
        String netBanking=null;
        if(netbankingYes.isSelected())
            netBanking = "NetBankingYes";
        else if( netbankingNo.isSelected())
                netBanking = "NetBankingNo";
        return netBanking;
       }
      
      public String getMobileBanking(){
           String mobileBanking=null;
        if(mobileBankingYes.isSelected())
            mobileBanking = "mobileBankingYes";
        else if( mobileBankingNo.isSelected())
                mobileBanking = "mobileBankingNo";
        return mobileBanking;
      }
      public String getCheckBook(){
           String checkBook=null;
        if(chequeBook25.isSelected())
            checkBook = "CHEQUE-25";
        else if( chequeBook50.isSelected())
                checkBook = "CHEQUE-50";
        else if( chequeBook100.isSelected())
                checkBook = "CHEQUE-100";
        else if( chequeBookNo.isSelected())
                checkBook = "CHEQUE-No";
            return checkBook;
      }
       public String getATMCard(){
           String atmCard=null;
        if(atmCardYes.isSelected())
            atmCard = "ATMCardYes";
        else if( atmCardNo.isSelected())
                atmCard = "ATMCardNo";
        return atmCard;
      }
     

   
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("SUBMIT")) {
            userAccountNumber = accountNumberField.getText().trim();
            ifscCode = ifscCodeField.getText().trim();
            micrCode = micrCodeField.getText().trim();
            accountType = getAccountType();
            netBanking = getNetBanking();
            mobileBanking = getMobileBanking();
            chequeBook = getCheckBook();
            atmCard = getATMCard();
            
           try {
               // Validating and Storing all data into Database;
               saveDataIntoDatabase();
           } catch (SQLException exception) {
               Logger.getLogger(AccountRegisterationThird.class.getName()).log(Level.SEVERE, null, exception);
           }             
       }    
    } 
    
    
     public void saveDataIntoDatabase() throws SQLException{
        try{
             connection = DatabaseConnection.ConnectionString(); 
             statement = connection.createStatement();
             String service_opted = "INSERT INTO service_opted(username, account_type, net_banking, mobile_banking, cheque_book, atm_card) VALUES"
                                + " ('" + getuserName + "', '" + accountType + "', '" + netBanking + "', '" + mobileBanking + "', '" + chequeBook + "', '" + atmCard + "')";
             
             String account_details = "INSERT INTO account_details(account_number, ifsc_code, micr_code, username) VALUES"
                                + " ('" + accountNumber + "', '" + ifscCode + "', '" + micrCode + "', '" + getuserName + "')";
 /*
             int rowsAffected = statement.executeUpdate(query1);
             int rowsAffected2 = statement.executeUpdate(query2);
             System.out.println("Rows affected1: " + rowsAffected);
             System.out.println("Rows affected2: " + rowsAffected2);
  */
            statement.executeUpdate(service_opted);
            statement.executeUpdate(account_details);
            int response = JOptionPane.showConfirmDialog(this, """
                                                            \t CEGians Bank !! 
                                                             Please Note it for Future Use                                                            
                                                            Account Number: \t """+accountNumber+"\n"+ "IFSC CODE: \t "+ifsccodes+"\n"+"MICR CODE:\t"
                 + micrcodes+"\nATM Number: \t"+atmNumber+"\n"+"Valid Thru:\t 05/28"+"\n"+"CVV: \t"+cvv+"\n\n"+"UserName:\t"+" "+getuserName
                 +"\n"+"Password:\t"+" "+password,"\n"
                 +"THANK YOU ❤️", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(response==JOptionPane.YES_OPTION){
                dispose();
                JOptionPane.showMessageDialog(this, "Acoount Registration SuccessFully !!\n"+"UserName: \t"+getuserName+"\n Password: \t"+password);
                new WelcomePage();
            }
        }catch(HeadlessException | ClassNotFoundException | SQLException exception){
                   System.out.println("Exception from Accoun-Registration Page-3: \n"+ exception);
        }finally{
              statement.close();
              connection.close();
        }
    }
}









/*
 public HashMap<String,String> userDetails(HashMap<String, String> users){
        this.users.put("accountNumber",accountNumberField.getText().trim());           this.users.put("ifscCode ",ifscCodeField.getText().trim());
        this.users.put("micrCode",micrCodeField.getText().trim());                     this.users.put("accountType",getAccountType());
        this.users.put("netbanking",getNetBanking());                                  this.users.put("mobileBanking",getMobileBanking());
        this.users.put("chequeBook",getCheckBook());                                   this.users.put("atmCard",getATMCard());
        System.out.println("Inside of UserDetails- Method: 3/3");
        System.out.println(this.users);
        return this.users;
    }
*/