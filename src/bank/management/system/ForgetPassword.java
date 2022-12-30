package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ForgetPassword extends JFrame implements ActionListener
{
    JPanel jpanel1, jpanel2, jpanel3;
    JLabel jemail, juname, jor, jinfo, jinfos,juname2,jpassword,jcpassword, jmobile;
    JTextField jemailId,jufiled,jufiled2,jpswrd, jcpswrd, jmobiles;
    JButton jexit,jsearch, jback, jclear, jclear2, jsubmit;
    ForgetPassword() {
        setResizable(false);
        setLayout(null);
        setSize(900,500);
        setLocation(300,150);
        setTitle("Forget Password Recovery");
        
        
        jpanel1= new JPanel();
        jpanel1.setBounds(0, 0,400,500);
        add(jpanel1);       
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/forgetImage.png"));
        Image img1 = img.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        JLabel Imagelabel = new JLabel(img2);
        Imagelabel.setBounds(0, 0, 250, 500);
        jpanel1.add(Imagelabel);
       
        jpanel2= new JPanel();
        jpanel2.setBounds(401, 0,500,500);
        jpanel2.setBackground(Color.blue);
        jpanel2.setLayout(null);
        add(jpanel2);
        
        jinfo = new JLabel("Search Yourself BY Given Options");
        jinfo.setBounds(120, 70, 300, 30);
        jinfo.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel2.add(jinfo);
        
  //Search Section by UserName || MobileNumber || EmailID:
        jemail = new JLabel("Email Id");
        jemail.setFont(new Font("verdana", Font.BOLD, 14));
        jemail.setBounds(20, 125, 80, 30);
        jpanel2.add(jemail);        
        jemailId = new JTextField();
        jemailId.setBounds(130, 120, 200, 40);
        jpanel2.add(jemailId);
       
        jor = new JLabel("OR");
        jor.setBounds(200, 162, 30, 30);
        jor.setFont(new Font("verdana", Font.BOLD, 12));
        jpanel2.add(jor);
        
        juname = new JLabel("Username");
        juname.setFont(new Font("verdana", Font.BOLD, 14));
        juname.setBounds(20,190,80,30);
        jpanel2.add(juname);
        jufiled = new JTextField();
        jufiled.setBounds(130, 190, 200, 40);
        jufiled.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel2.add(jufiled);
        
        jor = new JLabel("OR");
        jor.setBounds(200, 235, 30, 30);
        jor.setFont(new Font("verdana", Font.BOLD, 12));
        jpanel2.add(jor);
        
        jmobile = new JLabel("Mobile");
        jmobile.setFont(new Font("verdana", Font.BOLD, 14));
        jmobile.setBounds(20,265,80,30);
        jpanel2.add(jmobile);
        jmobiles = new JTextField();
        jmobiles.setBounds(130, 265, 200, 40);
        jmobiles.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel2.add(jmobiles);
        
//BUTTON in PANEL:-2
        //Search Button
        jsearch = new JButton("SEARCH");
        jsearch.setBounds(350,125,100,30);
        jsearch.addActionListener(this);
        jpanel2.add(jsearch); 
   
        //CLEAR Button
        jclear = new JButton("CLEAR");
        jclear.setBounds(350,193,100,30);
        jclear.addActionListener(this);
        jpanel2.add(jclear);
        
        //EXIT Button 
        jexit = new JButton("EXIT");
        jexit.setBounds(350,267,100,30);
        jexit.addActionListener(this);
        jpanel2.add(jexit);
      
      
// PANEL 3:- For RESET PASSWORD SECTION
    
        jpanel3= new JPanel();
        jpanel3.setBounds(401, 0,500,500);
        add(jpanel3);
        jpanel3.setLayout(null);
        jpanel3.setVisible(false);
             
//         ImageIcon panel3 = new ImageIcon(ClassLoader.getSystemResource("icons/background.png"));
//         Image panel3a = panel3.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
//         ImageIcon panel3b = new ImageIcon(panel3a);
//         JLabel imgLable = new JLabel(panel3b);
//         imgLable.setBounds(0,0,500,500);
//         jpanel3.add(imgLable);
//         
        
        jinfos = new JLabel("Reset Your Password");
        jinfos.setBounds(150, 80, 300, 30);
        jinfos.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel3.add(jinfos);
        
        juname2 = new JLabel("Username");
        juname2.setFont(new Font("verdana", Font.BOLD, 14));
        juname2.setBounds(30,140,80,30);
        jpanel3.add(juname2);
        jufiled2 = new JTextField();
        jufiled2.setEditable(false);
        jufiled2.setBounds(180, 140, 220, 40);
        jufiled2.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel3.add(jufiled2);
        
        jpassword = new JLabel("Password");
        jpassword.setFont(new Font("verdana", Font.BOLD, 14));
        jpassword.setBounds(30,200,80,30);
        jpanel3.add(jpassword);
        jpswrd = new JTextField();
        jpswrd.setBounds(180, 200, 220, 40);
        jpswrd.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel3.add(jpswrd);
        
        jcpassword = new JLabel("Confirm Password");
        jcpassword.setFont(new Font("verdana", Font.BOLD, 14));
        jcpassword.setBounds(30,260,180,30);
        jpanel3.add(jcpassword);
        jcpswrd = new JTextField();        
        jcpswrd.setBounds(180, 260, 220, 40);
        jcpswrd.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel3.add(jcpswrd);
        
        jclear2= new JButton("CLEAR");
        jclear2.setBounds(180,350,100,40);
        jclear2.addActionListener(this);
        jpanel3.add(jclear2);        
        
        jsubmit= new JButton("SUBMIT");
        jsubmit.setBounds(300,350,100,40);
        jsubmit.addActionListener(this);
        jpanel3.add(jsubmit);
        
        
        
        
        
        
        
        
        
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
//    public static void main(String[] args) {
//         new  ForgetPassword().setVisible(true);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          
     if(e.getActionCommand() == "SEARCH")
       {
          jpanel2.setVisible(false);
          jpanel3.setVisible(true);          
       }     
     if(e.getActionCommand() == "CLEAR")
       {
                 jemailId.setText("");
                 jufiled.setText("");
                 jmobiles.setText("");
                 jpswrd.setText("");
                 jcpswrd.setText("");
                 
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
