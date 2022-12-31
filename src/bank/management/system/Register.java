package bank.management.system;
//import com.toedter.Calendar.JDateChooser; 
import java.awt.Font;import java.awt.Image;
;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;
public class Register extends JFrame implements ActionListener{
     Random random ;
     String [] userData ={"","","","","","","","","","","","",""};
    int first4 ; String applicationNumber;
    JButton jexit, jclear,jnext;
    JPanel jpanel1;
    JLabel jfname, jlname,jacNo, jfaname,jmaname, jdob,jgender,jmartial,jemail,jmob,jaadharLabel,jpanCardLabel;
    JTextField jtname, jtlname,JacNum, jfatname,jmotname, jemailt, jmobile,jaadharText,jpanCardText;
    JRadioButton jmale,jfemale, jother, jmarried, junmarried, jdivorce;
    ButtonGroup genderGroup,martialStas;
    
   
   
    
//    HashMap<String, String> variableValue = new HashMap<String, String>();
    Register()
    {
        setTitle("Account Registration ||  Personal Details (1/3)");
        setResizable(false);
        setLayout(null);
        setSize(900,550);
        setLocation(300,100);
        
        random = new Random();
        first4 = Math.abs(random.nextInt());
      //  long first14 = (long)(rng.nextDouble() * 1000000000000L) + 14000000000000L;
         String num = Integer.toString(first4);
        //System.out.println("14 Numbers For account"+ " "+first14);
        //System.out.println("4 Numbers or Application Form "+ " "+first4);

        jpanel1= new JPanel();
        jpanel1.setBounds(0, 0,900,550);
        add(jpanel1);  
        jpanel1.setLayout(null);
        
       
        jacNo = new JLabel("Application Number");
        jacNo.setBounds(20, 10, 150, 30);
        jacNo.setFont(new Font("verdana", Font.BOLD, 12));
        jpanel1.add(jacNo); 
        JacNum = new JTextField();
        JacNum.setBounds(200, 10, 200, 30);
        JacNum.setFont(new Font("verdana", Font.ITALIC, 14));
        JacNum.setEditable(false); 
        JacNum.setText(num);
        jpanel1.add(JacNum);
        applicationNumber= JacNum.getText();
        
        
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image img1 = img.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1); 
        JLabel Imagelabel = new JLabel(img2);
        Imagelabel.setBounds(450, 0, 500, 100);
        jpanel1.add(Imagelabel);
        
        
        jfname = new JLabel("First Name");
        jfname.setBounds(20, 110, 150, 40);
        jfname.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(jfname);
        jtname = new JTextField();
        jtname.setBounds(200, 110, 200, 40);
        jtname.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(jtname);
       
        
        jlname = new JLabel("Last Name");
        jlname.setBounds(450, 110, 150, 40);
        jlname.setFont(new Font("verdana", Font.BOLD, 16));
        jpanel1.add(jlname);
        jtlname = new JTextField();
        jtlname.setBounds(650, 110, 200, 40);
        jtlname.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(jtlname);
        
        jfaname = new JLabel("Father Name");
        jfaname.setFont(new Font("verdana", Font.BOLD, 16));    
        jfaname.setBounds(20, 160, 150, 40);
        jpanel1.add(jfaname);
        jfatname = new JTextField();
        jfatname.setBounds(200, 160, 200, 40);
        jfatname.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jfatname);
       
        
        jmaname = new JLabel("Mother Name");
        jmaname.setFont(new Font("verdana", Font.BOLD, 16));    
        jmaname.setBounds(450, 160, 150, 40);
        jpanel1.add(jmaname);
        jmotname = new JTextField();
        jmotname.setBounds(650, 160, 200, 40);
        jmotname.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jmotname);
      
        jdob = new JLabel("D.O.B.");
        jdob.setBounds(20,210, 150, 40);
        jdob.setFont(new Font("verdana", Font.BOLD, 16));  
        jpanel1.add(jdob);
       
//        JDateChooser dateChoser = new JDateChooser();
//        dateChoser.setBounds(450, 120, 150, 40);
        
        jgender= new JLabel("Gender");
        jgender.setFont(new Font("verdana", Font.BOLD, 16)); 
        jgender.setBounds(450, 210, 150, 40);
        jpanel1.add(jgender);
        jmale = new JRadioButton("MALE");
        jmale.setBounds(570, 210, 70, 40);
        jmale.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(jmale);        
        jfemale = new JRadioButton("FEMALE");
        jfemale.setBounds(670, 210, 100, 40);
        jfemale.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(jfemale);        
        jother = new JRadioButton("OTHER");
        jother.setBounds(770, 210, 100, 40);
        jother.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(jother);
        
        genderGroup = new ButtonGroup(); 
        genderGroup.add(jmale);
        genderGroup.add(jfemale);
        genderGroup.add(jother);
         
          
        jmartial = new JLabel("Martial Status");
        jmartial.setBounds(20,260, 150, 40);
        jmartial.setFont(new Font("verdana", Font.BOLD, 16));  
        jpanel1.add(jmartial);        
        jmarried = new JRadioButton("MARRIED");
        jmarried.setBounds(200, 260, 150, 40);
        jmarried.setFont(new Font("verdana", Font.BOLD, 13));  
        jpanel1.add(jmarried);        
        junmarried = new JRadioButton("UNMARRIED");
        junmarried.setBounds(350, 260, 150, 40);
        junmarried.setFont(new Font("verdana", Font.BOLD, 13));  
        jpanel1.add(junmarried);        
        jdivorce = new JRadioButton("DIVORCE");
        jdivorce.setBounds(520, 260, 150, 40);
        jdivorce.setFont(new Font("verdana", Font.BOLD, 13));  
        jpanel1.add(jdivorce);        
        jother = new JRadioButton("OTHER");
        jother.setBounds(680, 260, 150, 40);
        jother.setFont(new Font("verdana", Font.BOLD, 13));  
        jpanel1.add(jother);
        
        martialStas = new ButtonGroup();
        martialStas.add(jmarried);
        martialStas.add(junmarried);
        martialStas.add(jdivorce);
        martialStas.add(jother);
           
        jemail = new JLabel("Email ID");
        jemail.setBounds(20, 310, 150, 40);
        jemail.setFont(new Font("verdana", Font.BOLD, 16));  
        jpanel1.add(jemail);        
        jemailt  = new JTextField();
        jemailt.setBounds(200, 310, 200, 40);
        jemailt.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(jemailt);
       
        jmob = new JLabel("Mobile Number");
        jmob.setBounds(450, 310, 150, 40);
        jmob.setFont(new Font("verdana", Font.BOLD, 16));  
        jpanel1.add(jmob);             
        jmobile  = new JTextField();
        jmobile.setBounds(650, 310, 200, 40);
        jmobile.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(jmobile);
        
        
        jpanCardLabel = new JLabel("PAN CARD NO");
        jpanCardLabel.setBounds(20, 360, 150, 40);
        jpanCardLabel.setFont(new Font("verdana", Font.BOLD, 14));  
        jpanel1.add(jpanCardLabel);        
        jpanCardText  = new JTextField();
        jpanCardText.setBounds(200, 360, 200, 40);
        jpanCardText.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(jpanCardText);
      
        jaadharLabel = new JLabel("Aadhar Number");
        jaadharLabel.setBounds(450, 360, 150, 40);
        jaadharLabel.setFont(new Font("verdana", Font.BOLD, 16));  
        jpanel1.add(jaadharLabel);               
        jaadharText  = new JTextField();
        jaadharText.setBounds(650, 360, 200, 40);
        jaadharText.setFont(new Font("verdana", Font.ITALIC, 14));
        jpanel1.add(jaadharText);
       
        
        
        
        
        jexit= new JButton("EXIT");
        jexit.setBounds(450,440,100,40);
        jexit.addActionListener(this);
        jpanel1.add(jexit);
        
        jclear = new JButton("CLEAR");
        jclear.setBounds(600,440,100,40);
        jclear.addActionListener(this);
        jpanel1.add(jclear);
            
        jnext = new JButton("NEXT");
        jnext.setBounds(750,440,100,40);
        jnext.addActionListener(this);
        jpanel1.add(jnext);
        
          
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }
    void assignData(){
        userData[0] = JacNum.getText();
          
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
          jtname.setText("");
          jtlname.setText("");
          jmotname.setText("");
          jemailt.setText("");
          jmobile.setText("");
       }       
       
        if(e.getActionCommand()== "NEXT"){
            dispose();
//           Users u = new Users();
//           u.setApplicationNumber(JacNum.getText());
//           u.setFirstName(jtname.getText());
//           u.setLastName(jtlname.getText());
//           u.setFatherName(jfname.getText());
//           u.setMotherName(jmotname.getText());
//          // u.setDateOfBirth(dateOfBirth);
//           u.setGender(genderGroup.getSelection().toString());
//           u.setEmailId(jemailt.getText());
           new RegisterSecond(applicationNumber);
           
        
       }
        
        
    }
    
}
