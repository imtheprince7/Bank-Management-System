package bank.management.system.bankfacility;

import bank.management.system.accountRegistration.WelcomePage;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChooseFacility extends JFrame implements ActionListener {

    JPanel mainPanel, imagePanel, facilityPanel;
    JLabel imagePicLabel, nameLabel, messageLabel;
    JTextField nameField;
    JButton mobileBankingButton, netBankingButton, kycUpdateButton, logoutButton, exitButton;
    String applicantName;

    public ChooseFacility(String name) {
        System.err.println("Coming Name is:"+" "+applicantName);
        applicantName = name;
        setTitle("BANK FACILITY WINDOW");
        setLayout(null);
        setResizable(false);
        setSize(700, 500);
        setLocation(400, 150);

        imagePanel = new JPanel();
        add(imagePanel);
        imagePanel.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image img1 = img.getImage().getScaledInstance(350, 450, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        imagePicLabel = new JLabel(img2);
        imagePanel.add(imagePicLabel);

        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(null);

        facilityPanel = new JPanel();
        add(facilityPanel);
        facilityPanel.setLayout(null);

        nameLabel = new JLabel("Hello");
        nameField = new JTextField();
        nameField.setEditable(false);
        nameField.setText(applicantName);

        messageLabel = new JLabel("Choose Any one of the banking facilities:");

        mobileBankingButton = new JButton("Mobile Banking");
        mobileBankingButton.addActionListener(this);
        netBankingButton = new JButton("Net Banking");
        netBankingButton.addActionListener(this);

        kycUpdateButton = new JButton("KYC Update");
        kycUpdateButton.addActionListener(this);
        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(this);
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);

        addComponent();
        setFont();
        setBound();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setFont() {

        nameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        nameField.setFont(new Font("verdana", Font.BOLD, 14));
        messageLabel.setFont(new Font("verdana", Font.BOLD, 16));
    }

    public void setBound() {

        mainPanel.setBounds(0, 0, 700, 500);
        imagePanel.setBounds(0, 40, 350, 450);
        facilityPanel.setBounds(350, 0, 350, 500);
        imagePicLabel.setBounds(0, 0, 350, 450);

        nameLabel.setBounds(10, 5, 50, 30);
        nameField.setBounds(70, 5, 275, 30);
        messageLabel.setBounds(370, 100, 250, 30);

        mobileBankingButton.setBounds(30, 200, 150, 40);
        netBankingButton.setBounds(210, 200, 120, 40);
        kycUpdateButton.setBounds(30, 300, 150, 40);
        exitButton.setBounds(210, 300, 120, 40);
        logoutButton.setBounds(230, 3, 100, 40);

    }

    public void addComponent() {
        mainPanel.add(facilityPanel);
        mainPanel.add(imagePanel);
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        facilityPanel.add(messageLabel);

        facilityPanel.add(mobileBankingButton);
        facilityPanel.add(netBankingButton);
        facilityPanel.add(kycUpdateButton);
        facilityPanel.add(exitButton);
        facilityPanel.add(logoutButton);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if ("LOGOUT".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to LOGOUT ?\n", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new WelcomePage();
            }
        }
        if ("EXIT".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to EXIT ?\n", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new ChooseFacility(applicantName);
            }
        }
        if ("Mobile Banking".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to GO on \n  MOBILE BANKING PAGE ?\n", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                try {
                    new MobileBanking(applicantName);
                } catch (HeadlessException  | ClassNotFoundException | SQLException exception) {
                    Logger.getLogger(ChooseFacility.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
        if ("Net Banking".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to GO on \n  NET BANKING PAGE ?\n", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                new NetBanking(applicantName);
            }
        }
        if ("KYC Update".equals(event.getActionCommand())) {
            int response = JOptionPane.showConfirmDialog(this, "Do You Want to GO on \n KYC DETAIL PAGE ?\n", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                try {
                    new KycUpdate(applicantName);
                } catch (HeadlessException | ClassNotFoundException |  SQLException exception) {
                    Logger.getLogger(ChooseFacility.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }
    
    
}
