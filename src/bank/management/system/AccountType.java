package bank.management.system;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountType extends JFrame implements ActionListener{
     Random random;
     long accountNumber;
     String accountNumberS, ifsccodes="CEGB3147000",micrcodes="110015317";
     JPanel jpanel1;
     JLabel jacNo, jAccountNumber, JIfscCode, JMicrCode;
     JTextField JacNumT, jAccountNumberT, JIfscCodeT, JMicrCodeT;
     JButton jClearB, jsubmit;
     
     
    AccountType( String acNum){
        setTitle("Account Registration || Account Type (3/3)");
        setLayout(null);
    // Disable Maximize Click
        setResizable(false);
        setSize(900,500);
        setLocation(300,150);
        
        jpanel1= new JPanel();
        jpanel1.setBounds(0, 0,900,500);
        add(jpanel1);  
        jpanel1.setLayout(null);
        
// Generating randomNumber for :- AcNo, IFSC, MICR 
        random = new Random();
       // accountNumber = Math.abs(random.nextInt());      firstL zero should be less than 3 of last-3147L zero 
       accountNumber = (long)Math.abs((random.nextDouble()* 100000L) + 314700000000L); 
        accountNumberS = Long.toString(accountNumber);
        
     /*   ifscCode = Math.abs(random.nextInt());  
        ifsccodeS = Integer.toString(ifscCode);
        String ifsc= "CEGB"+ifsccodeS;
        
        micrCode = Math.abs(random.nextInt());  
        micrcodeS = Integer.toString(micrCode); 
     */
        
        
        jacNo = new JLabel("Application Number");
        jacNo.setBounds(20, 20, 150, 30);
        jacNo.setFont(new Font("verdana", Font.BOLD, 12));
        jpanel1.add(jacNo);
        JacNumT = new JTextField();
        JacNumT.setBounds(200, 20, 200, 30);
        JacNumT.setFont(new Font("verdana", Font.ITALIC, 14));
        JacNumT.setEditable(false); 
        JacNumT.setText(acNum);
        jpanel1.add(JacNumT);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image img1 = img.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        JLabel Imagelabel = new JLabel(img2);
        Imagelabel.setBounds(420, 0, 500, 100);
        jpanel1.add(Imagelabel);
        
        jAccountNumber = new JLabel("Account Number");
        jAccountNumber.setBounds(20, 70, 150, 30);
        jAccountNumber.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jAccountNumber);
        jAccountNumberT = new JTextField();
        jAccountNumberT.setBounds(200, 70, 200, 30);
        jAccountNumberT.setFont(new Font("verdana", Font.BOLD, 14));
        jAccountNumberT.setEditable(false); 
        jAccountNumberT.setText(accountNumberS);
        jpanel1.add(jAccountNumberT);
        
        JIfscCode = new JLabel("IFSC Code");
        JIfscCode.setBounds(20, 120, 150, 30);
        JIfscCode.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(JIfscCode);
        JIfscCodeT = new JTextField();
        JIfscCodeT.setBounds(200, 120, 200, 30);
        JIfscCodeT.setFont(new Font("verdana", Font.BOLD, 14));
        JIfscCodeT.setEditable(false); 
        JIfscCodeT.setText(ifsccodes);
        jpanel1.add(JIfscCodeT);
        
        JMicrCode = new JLabel("MICR Code");
        JMicrCode.setBounds(20, 170, 150, 30);
        JMicrCode.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(JMicrCode);
        JMicrCodeT = new JTextField();
        JMicrCodeT.setBounds(200, 170, 200, 30);
        JMicrCodeT.setFont(new Font("verdana", Font.BOLD, 14));
        JMicrCodeT.setEditable(false); 
        JMicrCodeT.setText(micrcodes);
        jpanel1.add(JMicrCodeT);  



        
        
        
        jClearB = new JButton("CLEAR");
        jClearB.setBounds(600,400,100,40);
        jClearB.addActionListener(this);
        jpanel1.add(jClearB);
        
        jsubmit= new JButton("SUBMIT");
        jsubmit.setBounds(750,400,100,40);
        jsubmit.addActionListener(this);
        jpanel1.add(jsubmit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
        }    
   // CONSTRUCTOR CLOSE HERE
    

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
       if(e.getActionCommand()=="SUBMIT")
       {
         int response = JOptionPane.showConfirmDialog(this, "\t CEGians Bank !! \n Please Note it for Future Use\n\n"
                 + "Account Number: \t "+accountNumberS+"\n"+ "IFSC CODE: \t "+ifsccodes+"\n"+"MICR CODE:\t"
                 + micrcodes+"\n\n",
                 
                 "THANK YOU ❤️", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
         if(response==JOptionPane.YES_OPTION){
            dispose();
            new Login();
          }
         if(response==JOptionPane.NO_OPTION){
          
          }
       }
    
    
    }      // OVERRIDE METHOD CLOSE HERE
     

}    // MAIN CLASS END HERE
