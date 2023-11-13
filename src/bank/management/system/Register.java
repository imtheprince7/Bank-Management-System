package bank.management.system;

import bank.management.system.model.CustomerForm;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.ArrayList;

public class Register extends JFrame implements ActionListener{
    Random random ;
    String formNumber, userString, userApplication, customerName, userName,fatherName,motherName,
            dob,gender,martialStatus,emailId,mobileNo, panCard, aadharCard;
    JPanel PanelMain;
    JLabel applicationNoLabel, usernameLabel,firstNameLabel, lastNameLabel,fatherNameLabel,
            motherNameLabel, dobLabel,genderLabel,martialStatusLabel,emailIdLabel,mobileNoLabel,
            panCardLabel,aadharcardLabel;
   static JTextField applicationNoField, usernameField,firstNameField, lastNameField,fatherNameField,
            motherNameField, emailidField, mobileNoField,panCardField,aadharcardField;
    JRadioButton genderMale,genderFemale, buttonMarried, buttonUnmarried, buttonDivorce;
    ButtonGroup genderGroup,martialStatusGroup;
    JButton exitButton, clearButton,nextButton;
    JDateChooser dateChooser;
    
    HashMap<String,String> users = new HashMap<>();
    Register()
    {
        random = new Random();
        formNumber =Integer.toString( Math.abs(random.nextInt()));
        
        setTitle("Account Registration ||  Personal Details (1/3)");
        setResizable(false);
        setLayout(null);
        setSize(900,550);
        setLocation(200,100);
        
        PanelMain= new JPanel();
        PanelMain.setBounds(0, 0,900,550);
        add(PanelMain);  
        PanelMain.setLayout(null);
        
        // IMAGE ICON LOADER
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image img1 = img.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1); 
        JLabel Imagelabel = new JLabel(img2);
        Imagelabel.setBounds(450, 0, 500, 100);
        PanelMain.add(Imagelabel);
        
        
        
        applicationNoLabel = new JLabel("Application Number");
        applicationNoField =  new JTextField();
        applicationNoField.setText(formNumber);
        applicationNoField.setEditable(false);
        userApplication = formNumber.substring(0,5);
        
        
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
        
        genderLabel= new JLabel("Gender");
        genderMale = new JRadioButton("MALE", true);
        genderFemale = new JRadioButton("FEMALE");
       
        genderGroup = new ButtonGroup();
        genderGroup.add(this.genderMale);
        genderGroup.add(this.genderFemale);
        
        
        martialStatusLabel = new JLabel("Martial Status");
        buttonMarried = new JRadioButton("MARRIED");
        buttonUnmarried = new JRadioButton("UNMARRIED");
        buttonDivorce = new JRadioButton("DIVORCE");
        martialStatusGroup = new ButtonGroup();
        martialStatusGroup.add(this.buttonMarried);
        martialStatusGroup.add(this.buttonUnmarried);
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
        
        clearButton= new JButton("CLEAR");
        clearButton.addActionListener(this);
            
        nextButton = new JButton("NEXT");
        nextButton.addActionListener(this);        
        
        setFont();
        setBound();
        addComponent();        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
    }
    
    public void addComponent(){
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
        PanelMain.add(buttonUnmarried); 
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
    public void setFont(){       
        applicationNoLabel.setFont(new Font("verdana", Font.BOLD, 12));
        applicationNoField.setFont(new Font("verdana", Font.BOLD, 12));
        usernameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        usernameField.setFont(new Font("verdana", Font.BOLD, 16));
        firstNameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        lastNameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        fatherNameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        motherNameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        dobLabel.setFont(new Font("verdana", Font.BOLD, 16));
        genderLabel.setFont(new Font("verdana", Font.BOLD, 16));
        genderMale.setFont(new Font("verdana", Font.BOLD, 13));
        genderFemale.setFont(new Font("verdana", Font.BOLD, 13));
        martialStatusLabel.setFont(new Font("verdana", Font.BOLD, 16));
        buttonDivorce.setFont(new Font("verdana", Font.BOLD, 13));
        buttonMarried.setFont(new Font("verdana", Font.BOLD, 13));
        buttonUnmarried.setFont(new Font("verdana", Font.BOLD, 13));
        emailIdLabel.setFont(new Font("verdana", Font.BOLD, 16));
        mobileNoLabel.setFont(new Font("verdana", Font.BOLD, 16));
        panCardLabel.setFont(new Font("verdana", Font.BOLD, 16));
        aadharcardLabel.setFont(new Font("verdana", Font.BOLD, 16));
        aadharcardField.setFont(new Font("verdana", Font.ITALIC, 14));
    }
    
    public void setBound(){
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
        buttonMarried.setBounds(200, 260, 150, 40);
        buttonUnmarried.setBounds(400, 260, 150, 40);
        buttonDivorce.setBounds(600, 260, 150, 40);
        emailIdLabel.setBounds(20, 310, 150, 40);
        emailidField.setBounds(200, 310, 200, 40);
        mobileNoLabel.setBounds(450, 310, 150, 40);
        mobileNoField.setBounds(650, 310, 200, 40);
        panCardLabel.setBounds(20, 360, 150, 40);
        panCardField.setBounds(200, 360, 200, 40);
        aadharcardLabel.setBounds(450, 360, 150, 40);
        aadharcardField.setBounds(650, 360, 200, 40);
        exitButton.setBounds(450,440,100,40); 
        clearButton.setBounds(600,440,100,40);
        nextButton.setBounds(750,440,100,40);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       if("EXIT".equals(e.getActionCommand()))
       {
         int response = JOptionPane.showConfirmDialog(this, "Do You Want to EXIT ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
         if(response==JOptionPane.YES_OPTION){
            dispose();
            new Login();
          }
       }       
       if("CLEAR".equals(e.getActionCommand())){
           int response = JOptionPane.showConfirmDialog(this, "Do You Want to CLEAR ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
           if(response==JOptionPane.YES_OPTION){
               usernameField.setText("");
               firstNameField.setText("");   lastNameField.setText("");
               fatherNameField.setText("");  motherNameField.setText("");
               emailidField.setText("");     mobileNoField.setText("");
               aadharcardField.setText("");  panCardField.setText("");
           }
       }
       
       if("NEXT".equals(e.getActionCommand())){
            String userApplicationNumber = applicationNoField.getText().trim(), userName = getUserName();
           // printErrorMessage();
             userDetails(users);
             dispose();
           new RegisterSecond(users, userApplicationNumber,userName);
       }
    }
    // Event -Listener Method CLose here:
    public String getUserName(){
        userString = firstNameField.getText().substring(0).trim();
        return  userString.concat(userApplication);
    }
    public String getGender(){
        String gender=null;
        if(genderMale.isSelected())
            gender = "MALE";
        else if( genderFemale.isSelected())
                gender = "FEMALE";
        return gender;
       }
    
    public String getMartialStatus(){
        String martialStatus=null;
        if(buttonMarried.isSelected())
            martialStatus = "MARRIED";
        else if( buttonUnmarried.isSelected())
                martialStatus = "UNMARRIED";
        else
                martialStatus = "DIVORCE";
        return martialStatus;
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

}
