package bank.management.system;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountType extends JFrame implements ActionListener{
     Random random;
     long accountNumber;
    static String accountNumberS, ifsccodes="CEGB3147000",micrcodes="110015317";
     JPanel jpanel1;
     JLabel jacNo, jAccountNumber, JIfscCode, JMicrCode, JService,JNetbanking, JmobileBanking, JchequeBook, JAtmCard;
     JTextField JacNumT, jAccountNumberT, JIfscCodeT, JMicrCodeT;
     JRadioButton JnetYes, JnetNo, JmobYes, JmobNo, Jcheque25,Jcheque50,Jcheque100,JchequeNo, JAtmYes,JAtmNo ;
     ButtonGroup JNetbankingG, JMobilebankingG, JchequeG, JAtmG;
     JButton jClearB, jsubmit;
     
     
     ArrayList<String> user = new ArrayList<>();
     
    AccountType( String acNum,  ArrayList<String> us){
        user = us;
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
        jacNo.setFont(new Font("verdana", Font.BOLD, 14));
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
        jAccountNumber.setBounds(20, 60, 150, 30);
        jAccountNumber.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jAccountNumber);
        jAccountNumberT = new JTextField();
        jAccountNumberT.setBounds(200, 60, 200, 30);
        jAccountNumberT.setFont(new Font("verdana", Font.BOLD, 14));
        jAccountNumberT.setEditable(false); 
        jAccountNumberT.setText(accountNumberS);
        jpanel1.add(jAccountNumberT);
        
        JIfscCode = new JLabel("IFSC Code");
        JIfscCode.setBounds(20, 100, 150, 30);
        JIfscCode.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(JIfscCode);
        JIfscCodeT = new JTextField();
        JIfscCodeT.setBounds(200, 100, 200, 30);
        JIfscCodeT.setFont(new Font("verdana", Font.BOLD, 14));
        JIfscCodeT.setEditable(false); 
        JIfscCodeT.setText(ifsccodes);
        jpanel1.add(JIfscCodeT);
        
        JMicrCode = new JLabel("MICR Code");
        JMicrCode.setBounds(20, 140, 150, 30);
        JMicrCode.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(JMicrCode);
        JMicrCodeT = new JTextField();
        JMicrCodeT.setBounds(200, 140, 200, 30);
        JMicrCodeT.setFont(new Font("verdana", Font.BOLD, 14));
        JMicrCodeT.setEditable(false); 
        JMicrCodeT.setText(micrcodes);
        jpanel1.add(JMicrCodeT);  
        
        JService = new JLabel("Services for better banking facilities:");
        JService.setBounds(20, 180, 300, 40);
        JService.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(JService);
        
        JNetbanking= new JLabel("Net Banking");
        JNetbanking.setFont(new Font("verdana", Font.BOLD, 16)); 
        JNetbanking.setBounds(20, 210, 150, 40);
        jpanel1.add(JNetbanking);
        JnetYes = new JRadioButton("YES");
        JnetYes.setBounds(200, 210, 90, 40);
        JnetYes.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(JnetYes);        
        JnetNo = new JRadioButton("NO");
        JnetNo.setBounds(310, 210, 90, 40);
        JnetNo.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(JnetNo);  
        JNetbankingG = new ButtonGroup();
        JNetbankingG.add(JnetYes);
        JNetbankingG.add(JnetNo);
        
        JmobileBanking = new JLabel("Mobile Banking");
        JmobileBanking.setFont(new Font("verdana", Font.BOLD, 16)); 
        JmobileBanking.setBounds(20, 250, 150, 40);
        jpanel1.add(JmobileBanking);
        JmobYes = new JRadioButton("YES");
        JmobYes.setBounds(200, 250, 90, 40);
        JmobYes.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(JmobYes);        
        JmobNo = new JRadioButton("NO");
        JmobNo.setBounds(310, 250, 90, 40);
        JmobNo.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(JmobNo);  
        JMobilebankingG = new ButtonGroup();
        JMobilebankingG.add(JmobYes);
        JMobilebankingG.add(JmobNo);
        
        JchequeBook = new JLabel("Cheque Book");
        JchequeBook.setFont(new Font("verdana", Font.BOLD, 16)); 
        JchequeBook.setBounds(20, 290, 150, 40);
        jpanel1.add(JchequeBook);
        Jcheque25 = new JRadioButton("25 pages");
        Jcheque25.setBounds(200, 290, 100, 40);
        Jcheque25.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(Jcheque25);
        Jcheque50 = new JRadioButton("50 pages");
        Jcheque50.setBounds(320, 290, 100, 40);
        Jcheque50.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(Jcheque50);
        Jcheque100 = new JRadioButton("100 pages");
        Jcheque100.setBounds(450, 290, 120, 40);
        Jcheque100.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(Jcheque100);
        JchequeNo = new JRadioButton("NO");
        JchequeNo.setBounds(600, 290, 100, 40);
        JchequeNo.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(JchequeNo);
        JchequeG = new ButtonGroup();
        JchequeG.add(Jcheque25);
        JchequeG.add(Jcheque50);
        JchequeG.add(Jcheque100);
        JchequeG.add(JchequeNo);
       
        JAtmCard = new JLabel("ATM Card");
        JAtmCard.setFont(new Font("verdana", Font.BOLD, 16)); 
        JAtmCard.setBounds(20, 330, 150, 40);
        jpanel1.add(JAtmCard);
        JAtmYes = new JRadioButton("YES");
        JAtmYes.setBounds(200, 330, 90, 40);
        JmobYes.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(JAtmYes);        
        JAtmNo = new JRadioButton("NO");
        JAtmNo.setBounds(310, 330, 90, 40);
        JAtmNo.setFont(new Font("verdana", Font.BOLD, 13)); 
        jpanel1.add(JAtmNo);  
        JAtmG = new ButtonGroup();
        JAtmG.add(JAtmYes);
        JAtmG.add(JAtmNo);

        
        
        
        jClearB = new JButton("CLEAR");
        jClearB.setBounds(600,400,100,40);
        jClearB.addActionListener(this);
        jpanel1.add(jClearB);
        
        jsubmit= new JButton("SUBMIT");
        jsubmit.setBounds(750,400,100,40);
        jsubmit.addActionListener(this);
        jpanel1.add(jsubmit);
        
        
        
        
         // Printint ArrayList Element
         System.out.println("ArraList Element from first Page:");
           for (String str : us)
	      { 		      
	           System.out.println(str); 		
	      }
        
        
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
            
             userDetails(user);
             dispose();
            new Login();
          }
         if(response==JOptionPane.NO_OPTION){
          
          }
       }    
    
    }      // OVERRIDE METHOD CLOSE HERE
     
     public ArrayList<String> userDetails(ArrayList<String> user)
    {   // jAccountNumberT, JIfscCodeT, JMicrCodeT;
            user.add(jAccountNumberT.getText());
            user.add(JIfscCodeT.getText());
            user.add(JMicrCodeT.getText());
//            user.add( );
//            user.add( );
//            user.add( );
//            user.add( );
        return user;
    }
    
    

}    // MAIN CLASS END HERE
