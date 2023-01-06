package bank.management.system;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class RegisterThird extends JFrame implements ActionListener{
     Random random;
   public static  String password;
     String atmNumber,cvv;
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
     
    RegisterThird(ArrayList<String> us){
        user = us;
        random = new Random();
        password = getPassword();

        accountNumber = Long.toString((long)Math.abs((random.nextDouble()* 100000L) + 314700000000L));
        atmNumber = Long.toString((long)Math.abs((random.nextDouble()* 1000000000L) + 4601331700000000L));
        cvv = Integer.toString((int)Math.abs((random.nextDouble()*10)+300));
        
        setTitle("Account Registration || Account Type (3/3)");
        setLayout(null);
        setResizable(false);
        setSize(900,500);
        setLocation(200,100);
        
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
        applicationNoField.setText(user.get(0));       
        
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
        chequeBook25 = new JRadioButton("25 pages", true);
        chequeBook50 = new JRadioButton("50 pages");
        chequeBook100 = new JRadioButton("100 pages");
        chequeBookNo = new JRadioButton("NO");
        chequeBookGroup = new ButtonGroup();
        chequeBookGroup.add(chequeBook25);
        chequeBookGroup.add(chequeBook50);
        chequeBookGroup.add(chequeBook100);
        chequeBookGroup.add(chequeBookNo);
       
        atmCardLabel = new JLabel("ATM Card");
        atmCardYes = new JRadioButton("YES",true);      
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
        applicationNoLabel.setFont(new Font("verdana", Font.BOLD, 12));
        accountNumberLabel.setFont(new Font("verdana", Font.BOLD, 12));
        accountNumberField.setFont(new Font("verdana", Font.BOLD, 12));
        ifscCodeField.setFont(new Font("verdana", Font.BOLD, 12));
        micrCodeField.setFont(new Font("verdana", Font.BOLD, 12));
        ifscCodeLabel.setFont(new Font("verdana", Font.BOLD, 12));
        micrCodeLabel.setFont(new Font("verdana", Font.BOLD, 12));
        serviceLabel.setFont(new Font("verdana", Font.BOLD, 14));
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
        serviceLabel.setBounds(20, 190, 300, 30);
        netbankingLabel.setBounds(20, 230, 200, 30);
        netbankingYes.setBounds(200, 230, 80, 30);
        netbankingNo.setBounds(300, 230, 100, 30);
        mobileBankingLabel.setBounds(20, 270, 200, 30);
        mobileBankingYes.setBounds(200, 270, 80, 30);
        mobileBankingNo.setBounds(300, 270, 100, 30);
       chequeBookLabel.setBounds(20, 310, 200, 30);
       chequeBook25.setBounds(200, 310, 100, 30);
       chequeBook50.setBounds(350, 310, 100, 30);
       chequeBook100.setBounds(500, 310, 100, 30);
       chequeBookNo.setBounds(650, 310, 100, 30);
       atmCardLabel.setBounds(20, 350, 100, 30);
       atmCardYes.setBounds(200, 350, 100, 30);
       atmCardNo.setBounds(350, 350, 100, 30);
       clearButton.setBounds(600, 400, 100, 40);
       submitButton.setBounds(750, 400, 100, 40);
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
    
    // GENERATING RANDOM PASSWORD:---
    	public static String getPassword() 
	{
            String SALTCHARS = "ABCDENOPQRSTUWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
        while (salt.length() < 8) 
        { 
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
          return salt.toString();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
       if(e.getActionCommand()=="SUBMIT")
       {
         int response = JOptionPane.showConfirmDialog(this, "\t CEGians Bank !! \n Please Note it for Future Use\n\n"
                 + "Account Number: \t "+accountNumber+"\n"+ "IFSC CODE: \t "+ifsccodes+"\n"+"MICR CODE:\t"
                 + micrcodes+"\nATM Number: \t"+atmNumber+"\n"+"Valid Thru:\t 05/28"+"\n"+"CVV: \t"+cvv+"\n\n"+"UserName:\t"+user.get(1)
                 +"\n"+" Password:\t"+password,                 
                 
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
    {   
            user.add(accountNumberField.getText());
            user.add(ifscCodeField.getText());
            user.add(micrCodeField.getText());
            user.add(atmNumber);
            user.add(cvv);
            user.add(password);

        return user;
    }  
 }  
// MAIN CLASS END HERE
