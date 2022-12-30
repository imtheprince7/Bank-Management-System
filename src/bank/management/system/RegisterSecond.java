package bank.management.system;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterSecond extends JFrame implements ActionListener{
     String acnum;
     JPanel jpanel1;
     JLabel jacNo,jFlateNo, jStreet, jLandmark,jPincode,jDistrict,jCity,jState,jCountry;
     JTextField JacNum,jFlateNoT,jStreetT, jLandmarkT,jPincodeT,jDistrictT,jCityT,jStateT,jCountryT;
     JButton jNextB, jClearB;
     
    RegisterSecond( String acNum){       
        setResizable(false);
        setLayout(null);
        setSize(900,500);
        setLocation(300,150); 
        setTitle("Account Registration || Address Details (2/3)");
        
        jpanel1= new JPanel();
        jpanel1.setBounds(0, 0,900,500);
        add(jpanel1);  
        jpanel1.setLayout(null);
        
        jacNo = new JLabel("Application Number");
        jacNo.setBounds(20, 20, 150, 30);
        jacNo.setFont(new Font("verdana", Font.BOLD, 12));
        jpanel1.add(jacNo);
        JacNum = new JTextField();
        JacNum.setBounds(200, 20, 200, 30);
        JacNum.setFont(new Font("verdana", Font.ITALIC, 15));
        JacNum.setEditable(false); 
        JacNum.setText(acNum);
        acnum = acNum;
        jpanel1.add(JacNum);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image img1 = img.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);        
        JLabel Imagelabel = new JLabel(img2);
        Imagelabel.setBounds(450, 0, 500, 100);
        jpanel1.add(Imagelabel);
        
        jFlateNo = new JLabel("Flat No.");
        jFlateNo.setBounds(20, 70, 150, 30);
        jFlateNo.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jFlateNo);
        jFlateNoT = new JTextField();
        jFlateNoT.setBounds(200, 70, 200, 30);
        jFlateNoT.setFont(new Font("verdana", Font.ITALIC, 15));
        jpanel1.add(jFlateNoT);
        
        jStreet = new JLabel("Street No");
        jStreet.setBounds(20, 110, 150, 30);
        jStreet.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jStreet);
        jStreetT = new JTextField();
        jStreetT.setBounds(200, 110, 200, 30);
        jStreetT.setFont(new Font("verdana", Font.ITALIC, 15));
        jpanel1.add(jStreetT);
                
        jLandmark = new JLabel("Landmark");
        jLandmark.setBounds(20, 160, 150, 30);
        jLandmark.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jLandmark);
        jLandmarkT = new JTextField();
        jLandmarkT.setBounds(200, 160, 200, 30);
        jLandmarkT.setFont(new Font("verdana", Font.ITALIC, 15));
        jpanel1.add(jLandmarkT);
        
        jPincode = new JLabel("Pincode");
        jPincode.setBounds(20, 210, 150, 30);
        jPincode.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jPincode);
        jPincodeT = new JTextField();
        jPincodeT.setBounds(200, 210, 200, 30);
        jPincodeT.setFont(new Font("verdana", Font.ITALIC, 15));
        jpanel1.add(jPincodeT);
        
        jDistrict = new JLabel("District");
        jDistrict.setBounds(20, 260, 150, 30);
        jDistrict.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jDistrict);
        jDistrictT = new JTextField();
        jDistrictT.setBounds(200, 260, 200, 30);
        jDistrictT.setFont(new Font("verdana", Font.ITALIC, 15));
        jpanel1.add(jDistrictT);
        
        jCity = new JLabel("City");
        jCity.setBounds(20, 310, 150, 30);
        jCity.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jCity);
        jCityT = new JTextField();
        jCityT.setBounds(200, 310, 200, 30);
        jCityT.setFont(new Font("verdana", Font.ITALIC, 15));
        jpanel1.add(jCityT);
        
        jState = new JLabel("State");
        jState.setBounds(20, 360, 150, 30);
        jState.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jState);
        jStateT = new JTextField();
        jStateT.setBounds(200, 360, 200, 30);
        jStateT.setFont(new Font("verdana", Font.ITALIC, 15));
        jpanel1.add(jStateT);
        
        jCountry = new JLabel("Country");
        jCountry.setBounds(20, 410, 150, 30);
        jCountry.setFont(new Font("verdana", Font.BOLD, 14));
        jpanel1.add(jCountry);
        jCountryT = new JTextField();
        jCountryT.setBounds(200, 410, 200, 30);
        jCountryT.setFont(new Font("verdana", Font.ITALIC, 15));
        jpanel1.add(jCountryT);   
        
     // Button-Code-Here
     
        jClearB = new JButton("CLEAR");
        jClearB.setBounds(600,400,100,40);
        jClearB.addActionListener(this);
        jpanel1.add(jClearB);
        
        jNextB = new JButton("NEXT");
        jNextB.setBounds(750,400,100,40);
        jNextB.addActionListener(this);
        jpanel1.add(jNextB);
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);    
    }  
// CONSTRUCTOR END HERE !!
   
    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   if(e.getActionCommand()=="NEXT"){
       dispose();
       new AccountType(acnum);
   }
       
    }  // @OVERIRDE METHOD END HERE
    
} // MAIN CLASS END HERE
