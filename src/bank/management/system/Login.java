package bank.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author prince kumar singh
 */
public class Login extends JFrame implements ActionListener {
    
    JPanel panelImage, panelContent;
    JLabel imageLabel, messgaeLabel,usernameLabel,passwordLabel;
    JTextField usernameFiled,passwordFiled;
    JButton registerButton,loginButton,forgetpassowrdButton;
    
    Login(){
        setLayout(null);
        setResizable(false);
        setSize(900,500);
        setLocation(200,100);
        setTitle("HOME PAGE"); 
        
        panelImage = new JPanel();
        panelImage.setBounds(0, 0,350,500);
        add(panelImage); 
        panelImage.setLayout(null);        
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img1 = img.getImage().getScaledInstance(350, 500, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        imageLabel = new JLabel(img2);
        imageLabel.setBounds(0, 0, 350, 500);
        panelImage.add(imageLabel);       
        
        panelContent = new JPanel();
        panelContent.setBounds(355, 0,500,500);
        add(panelContent);
        panelContent.setLayout(null);
        
        
        messgaeLabel = new JLabel("Welcome To CEGians Bank");
        usernameLabel = new JLabel("Username");
        usernameFiled = new JTextField();
        
        passwordLabel = new JLabel("Password");
        passwordFiled = new JTextField();
        
        loginButton = new JButton("Sign In");
        loginButton.addActionListener(this);        
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        forgetpassowrdButton = new JButton("Forget password");
        forgetpassowrdButton.addActionListener(this);
                
        setFont();
        setBound();
        addComponent();
        
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
    }
    
    public void setFont(){
        messgaeLabel.setFont(new Font("verdana", Font.BOLD, 28));        
        usernameLabel.setFont(new Font("verdana", Font.BOLD, 14));
        usernameFiled.setFont(new Font("verdana", Font.ITALIC, 14));
        passwordLabel.setFont(new Font("verdana", Font.BOLD, 14));
        passwordFiled.setFont(new Font("verdana", Font.BOLD, 14));
    }
    public void setBound(){        
        messgaeLabel.setBounds(50,50,450,40);     
        usernameLabel.setBounds(40,150,100,50);        
        usernameFiled.setBounds(150, 150, 250, 40);
        passwordLabel.setBounds(40, 225,250,20);        
        passwordFiled.setBounds(150, 220, 250, 40);
        loginButton.setBounds(150,300,100,35);      
        registerButton.setBounds(300,300,100,35); 
        forgetpassowrdButton.setBounds(210,360,150,35);
    }
    public void addComponent(){
        panelContent.add(messgaeLabel);     panelContent.add(usernameLabel);
        panelContent.add(usernameFiled);    panelContent.add(passwordLabel);
        panelContent.add(passwordFiled);    panelContent.add(loginButton);
        panelContent.add(registerButton);   panelContent.add(forgetpassowrdButton);
    }
        
    
   public static void main(String [] args)
   {
   
       new Login();      
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
       if(e.getActionCommand()== "Forget password")
       {
           dispose();
           new InfoRecovery();          
       }
        if(e.getActionCommand()== "Register")
       {
           dispose();
           new Register();          
       }
        
        
         if(e.getActionCommand()== "Sign In")
       {
           if(usernameFiled.getText().equals("admin") && passwordFiled.getText().equals("admin"))
           {
               // Genreating Multiple Message on POP-UP
            JOptionPane.showMessageDialog(null,"userType:"+" "+usernameFiled.getText()+"\n"+" Password:"+" "+
                    passwordFiled.getText()+" ");
              dispose();
              new AdminPanel();
           }
           else
           {
               dispose();
               new Register();
           }
          
          
       }
              
    }
}