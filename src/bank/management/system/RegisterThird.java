package bank.management.system;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountType extends JFrame implements ActionListener{
     Random random;
     String formNumber;
     static String accountNumber, ifsccodes="CEGB3147000",micrcodes="110015317";
     JPanel mainPanel;
     JLabel applicationNoLabel, accountNumberLabel, ifscCodeLabel, micrCodeLabel, serviceLabel,netbankingLabel,
             mobileBankingLabel, chequeBookLabel, atmCardLabel;
     JTextField applicationNoField, accountNumberField, ifscCodeField, micrCodeField;
     JRadioButton netbankingYes, netbankingNo, mobileBankingYes, mobileBankingNo, chequeBook25,
                  chequeBook50,chequeBook100,chequeBookNo, atmCardYes,atmCardNo ;
     ButtonGroup netbankingGroup , mobileBankingGroup, chequeBookGroup, atmCardGroup;
     JButton clearButton, submitButton;
     ArrayList<String> user = new ArrayList<>();
     
    AccountType( String formnum, ArrayList<String> us){
        user = us;
        formNumber= formnum;
        random = new Random();
        accountNumber = Long.toString((long)Math.abs((random.nextDouble()* 100000L) + 314700000000L)); 
        setTitle("Account Registration || Account Type (3/3)");
        setLayout(null);
        setResizable(false);
        setSize(900,500);
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
        applicationNoField.setText(formNumber);       
        
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
        
        serviceLabel = new JLabel("Services for better banking facilities:");
       
        
        netbankingLabel= new JLabel("Net Banking");       
        netbankingYes = new JRadioButton("YES");
        netbankingNo = new JRadioButton("NO");       
        netbankingGroup = new ButtonGroup();
        netbankingGroup.add(netbankingYes);
        netbankingGroup.add(netbankingNo);
        
        mobileBankingLabel = new JLabel("Mobile Banking");
        mobileBankingYes = new JRadioButton("YES");      
        mobileBankingNo = new JRadioButton("NO");
        mobileBankingGroup= new ButtonGroup();
        mobileBankingGroup.add(mobileBankingYes);
        mobileBankingGroup.add(mobileBankingNo);
        
        chequeBookLabel = new JLabel("Cheque Book");
        chequeBook25 = new JRadioButton("25 pages");
        chequeBook50 = new JRadioButton("50 pages");
        chequeBook100 = new JRadioButton("100 pages");
        chequeBookNo = new JRadioButton("NO");
        chequeBookGroup = new ButtonGroup();
        chequeBookGroup.add(chequeBook25);
        chequeBookGroup.add(chequeBook50);
        chequeBookGroup.add(chequeBook100);
        chequeBookGroup.add(chequeBookNo);
       
        atmCardLabel = new JLabel("ATM Card");
        atmCardYes = new JRadioButton("YES");      
        atmCardNo = new JRadioButton("NO");
        atmCardGroup = new ButtonGroup();
        atmCardGroup.add(atmCardYes);
        atmCardGroup.add(atmCardNo);
        
        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);
        submitButton= new JButton("SUBMIT");
        submitButton.addActionListener(this);
                
        setFont();
        setBound();
        addComponent();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
    }    
   // CONSTRUCTOR CLOSE HERE
    
    public void setFont(){
        
    }
    
    public void setBound(){
        
    }
    
    public  void addComponent(){
        mainPanel.add(applicationNoLabel);  mainPanel.add(applicationNoField);
        mainPanel.add(accountNumberLabel);  mainPanel.add(accountNumberField);
        mainPanel.add(ifscCodeLabel);       mainPanel.add(ifscCodeField);
        mainPanel.add(micrCodeLabel);       mainPanel.add(micrCodeField);
        mainPanel.add(serviceLabel);        mainPanel.add(netbankingLabel);
        mainPanel.add(netbankingYes);       mainPanel.add(netbankingNo);
        mainPanel.add(mobileBankingLabel);  mainPanel.add(mobileBankingYes);    
        mainPanel.add(mobileBankingNo);     mainPanel.add(chequeBookLabel);
        mainPanel.add(chequeBook25);        mainPanel.add(chequeBook50);
        mainPanel.add(chequeBook100);       mainPanel.add(chequeBookNo);
        mainPanel.add(atmCardLabel);        mainPanel.add(atmCardYes);
        mainPanel.add(atmCardNo);           mainPanel.add(clearButton);
        mainPanel.add(submitButton);        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
       if(e.getActionCommand()=="SUBMIT")
       {
         int response = JOptionPane.showConfirmDialog(this, "\t CEGians Bank !! \n Please Note it for Future Use\n\n"
                 + "Account Number: \t "+accountNumber+"\n"+ "IFSC CODE: \t "+ifsccodes+"\n"+"MICR CODE:\t"
                 + micrcodes+"\n\n",
                 
                 "THANK YOU ❤️", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
         if(response==JOptionPane.YES_OPTION){
            Database db = new Database();
            db.saveData(user);
             dispose();
            new Login();
          }
         if(response==JOptionPane.NO_OPTION){
          
          }
       }    
    }      // OVERRIDE METHOD CLOSE HERE
     
     public ArrayList<String> userDetails(ArrayList<String> user)
    {   // jAccountNumberT, JIfscCodeT, JMicrCodeT;
            user.add(accountNumberField.getText());
            user.add(ifscCodeField.getText());
            user.add(micrCodeField.getText());

        return user;
    }  
 }  
// MAIN CLASS END HERE
