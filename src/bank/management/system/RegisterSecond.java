package bank.management.system;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterSecond extends JFrame implements ActionListener{

     JPanel mainPanel;
     JLabel applicationNoLabel, flateNoLabel, streetLabel, landmarkLabel,pincodeLabel,districtLabel,cityLabel,
            stateLabel,countryLabel;
     JTextField applicationNoField,flateNoField,streetField, landmarkField,pincodeField,districtField,
                cityField,stateField,countryField;         
     JButton nextButton, clearButton;
     
     ArrayList<String> user = new ArrayList<>();
     
     
    RegisterSecond(ArrayList<String> us){  
        user = us;
        setResizable(false);
        setLayout(null);
        setSize(900,510);
        setLocation(200,100); 
        setTitle("Account Registration || Address Details (2/3)");
        
        mainPanel= new JPanel();
        mainPanel.setBounds(0, 0,900,500);
        add(mainPanel);  
        mainPanel.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image img1 = img.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        JLabel Imagelabel = new JLabel(img2);
        Imagelabel.setBounds(450, 0, 500, 100);
        mainPanel.add(Imagelabel);
        
        applicationNoLabel = new JLabel("Application Number");
        applicationNoField = new JTextField();
        applicationNoField.setEditable(false); 
        applicationNoField.setText(user.get(0));     
        
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
    
    public void setFont(){
        applicationNoLabel.setFont(new Font("verdana", Font.BOLD, 12));
        flateNoLabel.setFont(new Font("verdana", Font.BOLD, 14));
        streetLabel.setFont(new Font("verdana", Font.BOLD, 14));
        landmarkLabel.setFont(new Font("verdana", Font.BOLD, 14));
        pincodeLabel.setFont(new Font("verdana", Font.BOLD, 14));
        districtLabel.setFont(new Font("verdana", Font.BOLD, 14));
        cityLabel.setFont(new Font("verdana", Font.BOLD, 14));
        stateLabel.setFont(new Font("verdana", Font.BOLD, 14));
        countryLabel.setFont(new Font("verdana", Font.BOLD, 14));
    }
    
    public void setBound(){
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
        clearButton.setBounds(600, 400, 100 , 40); 
        nextButton.setBounds(750, 400, 100, 40);
   }
    
   public void addComponent(){
       
        mainPanel.add(applicationNoLabel);  mainPanel.add(applicationNoField);
        mainPanel.add(flateNoLabel);        mainPanel.add(flateNoField);
        mainPanel.add(streetLabel);         mainPanel.add(streetField);
        mainPanel.add(landmarkLabel);       mainPanel.add(landmarkField);
        mainPanel.add(pincodeLabel);        mainPanel.add(pincodeField);
        mainPanel.add(districtLabel);       mainPanel.add(districtField);
        mainPanel.add(cityLabel);           mainPanel.add(cityField);
        mainPanel.add(stateLabel);          mainPanel.add(stateField);
        mainPanel.add(countryLabel);        mainPanel.add(countryField);
        mainPanel.add(clearButton);         mainPanel.add(nextButton);        
  } 
            
            
    
    
// CONSTRUCTOR END HERE !!
   
    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); 

      if(e.getActionCommand()=="CLEAR"){
          flateNoField.setText("");     streetField.setText("");
          landmarkField.setText("");    pincodeField.setText("");
          districtField.setText("");    cityField.setText("");
          stateField.setText("");       countryField.setText("");            
     }

     if(e.getActionCommand()=="NEXT"){
       
       userDetails(user);
       dispose();
       new RegisterThird(user);
     }
     
    }  // @OVERIRDE METHOD END HERE
    
    
           
 public ArrayList<String> userDetails(ArrayList<String> user)
    {
            user.add(flateNoField.getText());
            user.add(streetField.getText());
            user.add(landmarkField.getText());
            user.add(pincodeField.getText());
            user.add(districtField.getText());
            user.add(cityField.getText());
            user.add(stateField.getText());
            user.add(countryField.getText());          
            return user;
    }
    // ArrayList userDetails method end Here///
    
} // MAIN CLASS END HERE
