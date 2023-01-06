package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class InfoRecovery extends JFrame implements ActionListener
{
    JPanel imagePanel, searchPanel, recoveryPanel;
    JLabel imageLabel, emailLabel, userNameLabel, orLabel, infoLabel, resetLabel,userName2Label,passwordLabel,cpasswordLabel, mobileLabel;
    JTextField emailIdField,userNameField,UserName2Field,passowrdField, cpasswordField, mobileField;
    JButton exitButton, searchButton, clearButton, clear2Button, submitButton;
    
    InfoRecovery() {
        setResizable(false);
        setLayout(null);
        setSize(900,500);
        setLocation(200,100);
        setTitle("Forget Password Recovery");
        
        
        imagePanel= new JPanel();       
        add(imagePanel);       
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/forgetImage.png"));
        Image img1 = img.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        imageLabel = new JLabel(img2);
       
        searchPanel= new JPanel();        
        searchPanel.setBackground(Color.blue);
        searchPanel.setLayout(null);
        add(searchPanel);
        
        infoLabel = new JLabel("Search Yourself BY Given Options");
        emailLabel = new JLabel("Email Id");       
        emailIdField = new JTextField();
        orLabel = new JLabel("OR");
        
        userNameLabel = new JLabel("Username");
        userNameField = new JTextField();
        orLabel = new JLabel("OR");  
        mobileLabel = new JLabel("Mobile");
        mobileField = new JTextField();        
        
        searchButton = new JButton("SEARCH");       
        searchButton.addActionListener(this);   
        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);        
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);
    
        
        recoveryPanel= new JPanel();        
        add(recoveryPanel);
        recoveryPanel.setLayout(null);
        recoveryPanel.setVisible(false);
        
        resetLabel = new JLabel("Reset Your Password");        
        userName2Label = new JLabel("Username"); 
        UserName2Field = new JTextField();
        UserName2Field.setEditable(false);
       
        passwordLabel = new JLabel("Password");
        passowrdField = new JTextField();
        cpasswordLabel = new JLabel("Confirm Password");
        cpasswordField = new JTextField();   
        
        clear2Button= new JButton("CLEAR");
        clear2Button.addActionListener(this);           
        submitButton= new JButton("SUBMIT");
        submitButton.addActionListener(this);     
        
        
        setFont();
        setBound();
        addComponent(); 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setFont(){
        infoLabel.setFont(new Font("verdana", Font.BOLD, 14));
        emailLabel.setFont(new Font("verdana", Font.BOLD, 14));
        orLabel.setFont(new Font("verdana", Font.BOLD, 12));
        userNameLabel.setFont(new Font("verdana", Font.BOLD, 14));         
        userNameField.setFont(new Font("verdana", Font.ITALIC, 14));
        orLabel.setFont(new Font("verdana", Font.BOLD, 12));
        mobileLabel.setFont(new Font("verdana", Font.BOLD, 14));
        mobileField.setFont(new Font("verdana", Font.ITALIC, 14));         
        resetLabel.setFont(new Font("verdana", Font.BOLD, 16));
        userName2Label.setFont(new Font("verdana", Font.BOLD, 14));       
        UserName2Field.setFont(new Font("verdana", Font.ITALIC, 14));        
        passwordLabel.setFont(new Font("verdana", Font.BOLD, 14));        
        passowrdField.setFont(new Font("verdana", Font.ITALIC, 14));
        cpasswordLabel.setFont(new Font("verdana", Font.BOLD, 14));
        cpasswordField.setFont(new Font("verdana", Font.ITALIC, 14));        
    }
    
    public void setBound(){
        imagePanel.setBounds(0, 0,400,500);
        recoveryPanel.setBounds(401, 0,500,500);
        searchPanel.setBounds(401, 0,500,500);
        infoLabel.setBounds(120, 70, 300, 30);
        emailLabel.setBounds(20, 125, 80, 30);
        emailIdField.setBounds(130, 120, 200, 40);
        orLabel.setBounds(200, 162, 30, 30);
        userNameLabel.setBounds(20,190,80,30);
        userNameField.setBounds(130, 190, 200, 40);
        orLabel.setBounds(200, 235, 30, 30);
        mobileLabel.setBounds(20,265,80,30);
        mobileField.setBounds(130, 265, 200, 40);
        searchButton.setBounds(350,125,100,30);
        clearButton.setBounds(350,193,100,30);
        exitButton.setBounds(350,267,100,30);        
        imageLabel.setBounds(0, 0, 250, 500);        
        resetLabel.setBounds(150, 80, 300, 30);
        userName2Label.setBounds(30,140,80,30);
        UserName2Field.setBounds(180, 140, 220, 40);
        passwordLabel.setBounds(30,200,80,30);
        passowrdField.setBounds(180, 200, 220, 40);        
        cpasswordLabel.setBounds(30,260,180,30);  
        cpasswordField.setBounds(180, 260, 220, 40);
        clear2Button.setBounds(180,350,100,40);
        submitButton.setBounds(300,350,100,40);
    }
    
    public void addComponent(){
        searchPanel.add(infoLabel);     searchPanel.add(emailLabel);  
        searchPanel.add(emailIdField);  searchPanel.add(orLabel);
        searchPanel.add(userNameLabel); searchPanel.add(userNameField);
        searchPanel.add(orLabel);       searchPanel.add(mobileLabel);
        searchPanel.add(mobileField);   searchPanel.add(searchButton);         
        recoveryPanel.add(resetLabel);  recoveryPanel.add(userName2Label);
        recoveryPanel.add(UserName2Field); recoveryPanel.add(passwordLabel);
        recoveryPanel.add(passowrdField);  recoveryPanel.add(cpasswordLabel);        
        recoveryPanel.add(cpasswordField); imagePanel.add(imageLabel);
        searchPanel.add(clearButton);      searchPanel.add(exitButton);
        recoveryPanel.add(clear2Button);   recoveryPanel.add(submitButton);   
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); 

          
     if(e.getActionCommand() == "SEARCH")
       {
          searchPanel.setVisible(false);
          recoveryPanel.setVisible(true);          
       }     
     if(e.getActionCommand() == "CLEAR")
       {
                 emailIdField.setText("");
                 userNameField.setText("");
                 mobileField.setText("");
                 passowrdField.setText("");
                 cpasswordField.setText("");
                 
       }
     if(e.getActionCommand()== "EXIT")
       {
         int response = JOptionPane.showConfirmDialog(this, "Do You Want to EXIT ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
         if(response==JOptionPane.YES_OPTION){
            dispose();
            new Login();
          }
       }
     
        if(e.getActionCommand()== "SUBMIT")
       {
           dispose();
           new Login();
       } 
    }
    
}
