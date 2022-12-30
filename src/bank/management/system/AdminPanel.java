package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AdminPanel extends JFrame implements ActionListener {
    JPanel jpanel1, jpanel2, jpanel3;
    JLabel jName,jInfo, jUsername, JFullName, JMobile, JEmail, JType, JPassword, JCPassword;
    JTextField jUsernameT, JFullNameT, JMobileT, JEmailT, JTypeT,JPasswordT, JCPasswordT;
    JButton jCreate, JClear, Jcheckusers,JLogOut, JBack;
    String Name;
    AdminPanel(String name){
        Name = name;
        setResizable(false);
        setLayout(null);
        setSize(1000,500);
        setLocation(250,150);
        setTitle("Admin Panel");
        
        jpanel3 = new JPanel();
        jpanel3.setBounds(0, 0,1000,500);
        add(jpanel3);  
        jpanel3.setLayout(null);  
        
        
        jpanel1 = new JPanel();
        jpanel1.setBounds(250, 15,1000,500);
        add(jpanel1);  
        jpanel1.setLayout(null);   
       
        jpanel2 = new JPanel();
        jpanel2.setBounds(0, 0,1000,500);
        add(jpanel2);  
        jpanel2.setBackground(Color.red);
        jpanel2.setLayout(null);
        jpanel2.setVisible(false);
        jpanel3.add(jpanel1);
        jpanel3.add(jpanel2);
        
        jName = new JLabel("Welcome \t Mr."+" "+Name);
        jName.setBounds(10, 5, 550, 30);
        jName.setFont(new Font("verdana", Font.BOLD, 13));
        jpanel3.add(jName);
        
        jInfo = new JLabel("Create New Users ||  Admins");
        jInfo.setBounds(100, 25, 250, 50);
        jInfo.setFont(new Font("verdana", Font.BOLD, 12));
        jpanel1.add(jInfo);
        
        jUsername = new JLabel("UserName");
        jUsername.setBounds(20, 75, 150, 40);
        jUsername.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(jUsername);
        jUsernameT = new JTextField();
        jUsernameT.setBounds(200, 75, 200, 40);
        jUsernameT.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(jUsernameT);
        
        JFullName = new JLabel("Full Name");
        JFullName.setBounds(20, 120, 150, 40);
        JFullName.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(JFullName);
        JFullNameT = new JTextField();
        JFullNameT.setBounds(200, 120, 200, 40);
        JFullNameT.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(JFullNameT);
        
        JMobile = new JLabel("Mobile No");
        JMobile.setBounds(20, 165, 160, 40);
        JMobile.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(JMobile);
        JMobileT = new JTextField();
        JMobileT.setBounds(200, 165, 200, 40);
        JMobileT.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(JMobileT);
        
        JEmail = new JLabel("Email Id");
        JEmail.setBounds(20,210, 200, 40);
        JEmail.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(JEmail);
        JEmailT = new JTextField();
        JEmailT.setBounds(200, 210, 200, 40);
        JEmailT.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(JEmailT);
        
        JType = new JLabel("Account Type");
        JType.setBounds(20, 255, 150, 40);
        JType.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(JType);
        JTypeT = new JTextField();
        JTypeT.setBounds(200, 255, 200, 40);
        JTypeT.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(JTypeT);
        
        JPassword = new JLabel("Password");
        JPassword.setBounds(20, 300, 150, 40);
        JPassword.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(JPassword);
        JPasswordT = new JTextField();
        JPasswordT.setBounds(200, 300, 200, 40);
        JPasswordT.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(JPasswordT);
        
        JCPassword = new JLabel("Confirm Password");
        JCPassword.setBounds(20, 345, 180, 40);
        JCPassword.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(JCPassword);
        JCPasswordT = new JTextField();
        JCPasswordT.setBounds(200, 345, 200, 40);
        JCPasswordT.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(JCPasswordT);
        
        JClear = new JButton("CLEAR");
        JClear.setBounds(20,405,80,30);
        JClear.addActionListener(this);
        jpanel1.add(JClear);
        
        jCreate = new JButton("Create User");
        jCreate.setBounds(130,405,120,30);
        jCreate.addActionListener(this);
        jpanel1.add(jCreate);
        
        Jcheckusers = new JButton("Check Users");
        Jcheckusers.setBounds(280,405,120,30);
        Jcheckusers.addActionListener(this);
        jpanel1.add(Jcheckusers);
        
        JLogOut = new JButton("LOGOUT");
        JLogOut.setBounds(895,0,90,25);
        JLogOut.addActionListener(this);
        jpanel3.add(JLogOut);
        
        JBack = new JButton("BACK");
        JBack.setBounds(890,435,90,25);
        JBack.addActionListener(this);        
        jpanel2.add(JBack);
        
        
        
        
       
        
        
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
    }
    // Constructor CLose Here...!!
    

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       if(e.getActionCommand()=="LOGOUT"){
        int response = JOptionPane.showConfirmDialog(this, "Do You Want to Logout ?", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            dispose();
            new Login();
        }
//        else if(response==JOptionPane.NO_OPTION){
//            new AdminPanel();
//        }
//        else{
//           new AdminPanel();   
//        }
    }
       if(e.getActionCommand()=="CLEAR"){
           jUsernameT.setText("");
           JFullNameT.setText("");
           JMobileT.setText("");
           JEmailT.setText("");
           JTypeT.setText("");
           JPasswordT.setText("");
           JCPasswordT.setText("");
           
       }
       if(e.getActionCommand()=="Create User"){
           
       }
       
       if(e.getActionCommand()=="Check Users"){
          jpanel2.setVisible(true);
          jpanel1.setVisible(false);
       }
       
       if(e.getActionCommand()=="BACK"){
           jpanel2.setVisible(false);
           jpanel1.setVisible(true);
           
       }
           
    
    }
    
}
