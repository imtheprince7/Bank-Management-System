package bank.management.system;

import java.awt.Font;import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Register extends JFrame implements ActionListener{
    Random random ;
    String formNumber;   
   
    JPanel PanelMain;
    JLabel applicationNoLabel, usernameLabel,firstNameLabel, lastNameLabel,fatherNameLabel,
            motherNameLabel, dobLabel,genderLabel,martialStatusLabel,emailIdLabel,mobileNoLabel,
            panCardLabel,aadharcardLabel;
    JTextField applicationNoField, usernameField,firstNameField, lastNameField,fatherNameField,
            motherNameField, emailidField, mobileNoField,panCardField,aadharcardField;
    JRadioButton genderMale,genderFemale, genderOther, buttonMarried, buttonUnmarried, buttonDivorce;
    ButtonGroup genderGroup,martialStatusGroup;
    JButton exitButton, clearButton,nextButton;
    
    ArrayList<String> us = new ArrayList<>();
    
    
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
        
        
        usernameLabel = new JLabel("Username");      
        usernameField = new JTextField();
        
        firstNameLabel = new JLabel("First Name"); 
        firstNameField = new JTextField();
        
        lastNameLabel = new JLabel("Last Name");
        lastNameField = new JTextField();
       
        fatherNameLabel = new JLabel("Father Name");
        fatherNameField = new JTextField();
          
        motherNameLabel = new JLabel("Mother Name");
        motherNameField = new JTextField();
      
        dobLabel = new JLabel("D.O.B.");
       
        
        genderLabel= new JLabel("Gender");
        genderMale = new JRadioButton("MALE", true);
        genderFemale = new JRadioButton("FEMALE");
        genderOther = new JRadioButton("OTHER");
//        genderGroup.add(genderMale);
//        genderGroup.add(genderFemale);
//        genderGroup.add(genderOther);
        
        martialStatusLabel = new JLabel("Martial Status");
        buttonMarried = new JRadioButton("MARRIED");
        buttonUnmarried = new JRadioButton("UNMARRIED");
        buttonDivorce = new JRadioButton("DIVORCE");
//        martialStatusGroup.add(buttonMarried);
//        martialStatusGroup.add(buttonUnmarried);
//        martialStatusGroup.add(buttonDivorce);
       
        emailIdLabel = new JLabel("Email ID");
        emailidField = new JTextField();
        
        mobileNoLabel = new JLabel("Mobile Number");
        mobileNoField = new JTextField();

        panCardLabel = new JLabel("PANCARD NO");
        panCardField = new JTextField();        
              
        aadharcardLabel = new JLabel("Aadhar Number");
        aadharcardField = new JTextField();
        
        
        exitButton = new JButton("EXIT");
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
        PanelMain.add(applicationNoLabel);  PanelMain.add(applicationNoField);
        PanelMain.add(usernameLabel);       PanelMain.add(usernameField);
        PanelMain.add(firstNameLabel);      PanelMain.add(firstNameField);
        PanelMain.add(lastNameLabel);       PanelMain.add(lastNameField);
        PanelMain.add(fatherNameLabel);     PanelMain.add(fatherNameField);
        PanelMain.add(motherNameLabel);     PanelMain.add(motherNameField);
        PanelMain.add(dobLabel);
        PanelMain.add(genderLabel);         PanelMain.add(genderMale);
        PanelMain.add(genderFemale);        PanelMain.add(genderOther);
        PanelMain.add(martialStatusLabel);  PanelMain.add(buttonMarried);
        PanelMain.add(buttonUnmarried);     PanelMain.add(buttonDivorce);
        PanelMain.add(emailIdLabel);        PanelMain.add(emailidField);
        PanelMain.add(mobileNoLabel);       PanelMain.add(mobileNoField);
        PanelMain.add(panCardLabel);        PanelMain.add(panCardField);
        PanelMain.add(aadharcardLabel);     PanelMain.add(aadharcardField);
        PanelMain.add(exitButton);          PanelMain.add(clearButton);
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
        genderOther.setFont(new Font("verdana", Font.BOLD, 13)); 
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
    
       if(e.getActionCommand()== "EXIT")
       {
         int response = JOptionPane.showConfirmDialog(this, "Do You Want to EXIT ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
         if(response==JOptionPane.YES_OPTION){
            dispose();
            new Login();
          }
       }       
       if(e.getActionCommand()== "CLEAR"){
        usernameField.setText("");
         firstNameField.setText("");   lastNameField.setText("");
         fatherNameField.setText("");  motherNameField.setText("");
         emailidField.setText("");     mobileNoField.setText("");
         aadharcardField.setText("");  panCardField.setText("");
       }       
       
        if(e.getActionCommand()== "NEXT"){
            userDetails(us);
            dispose();
           new RegisterSecond(us);
       }
    }
    // Event -Listener Method CLose here:---

    public ArrayList<String> userDetails(ArrayList<String> us)
    {
            us.add(applicationNoField.getText());
            us.add(usernameField.getText());
            us.add(firstNameField.getText());
            us.add(lastNameField.getText());
            us.add(fatherNameField.getText());
            us.add(motherNameField.getText());
            us.add("dateOfBirth");
            us.add("gender");
            us.add("martialStatus");
            us.add(emailidField.getText());
            us.add(mobileNoField.getText());
            us.add(panCardField.getText());
            us.add(aadharcardField.getText());
            
            return us;
    }    
}
