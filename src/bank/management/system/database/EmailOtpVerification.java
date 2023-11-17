package bank.management.system.database;

import bank.management.system.accountRegistration.WelcomePage;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Random;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/*
        This class is created for Send-Email for email-OTP verification 
        and generate Random 4-digit-OTP:

        TO remove the error of javax.mail.internet.mimemessage  NOT FOUND
        I have downloaded the jar file from mention link:  
        http://www.java2s.com/Code/Jar/j/Downloadjavaxmail146jar.htm
        Same can do in maven project add dependecies.
 */
public class EmailOtpVerification {

    public static Random random;

    public static void sendEmail(String otp, String Loginname, String userName, String emailId) {

        String subject = "OTP for Bank Management System Login :Confirmation";
        String toWhom = "emailId";
        String address = "otpsystem3@gmail.com";

        //Variable for gmail
        String host = "smtp.gmail.com";
        otp = "Your one time password is " + otp + "\n which is sent by " + Loginname + " (" + userName + ")";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //setting important information to properties object
        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Step 1: to get the session object..
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("otpsystem3@gmail.com", "awwdbvfekqnpfqcq");
            }
        });
        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            //from email
            mimeMessage.setFrom(new InternetAddress(address));
            //adding recipient to message
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toWhom));

            //adding subject to message
            mimeMessage.setSubject(subject);
            //adding text to message
            mimeMessage.setText(otp);

            //send 
            //Step 3 : send the message using Transport class
            Transport.send(mimeMessage);
            System.err.println("Sessin" + session);
            Transport.send(mimeMessage);
            System.out.println("Sent success...................");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String getFormNumber() {
        random = new Random();
        return Integer.toString(Math.abs(random.nextInt()));
    }

    public static String getAccountNumber() {
        random = new Random();
        return Long.toString((long) Math.abs((random.nextDouble() * 100000L) + 314700000000L));
    }

    public static String getAtmNumber() {
        random = new Random();
        return Long.toString((long) Math.abs((random.nextDouble() * 1000000000L) + 4601331700000000L));
    }

    public static String getCVVNumber() {
        random = new Random();
        return Integer.toString((int) Math.abs((random.nextDouble() * 10) + 300));
    }

    public static String generateOTP() {
        int len = 4;
        System.out.print("Your OTP for email-verification is: ");
        // Using numeric values
        String numbers = "0123456789";
        // Using random method
        random = new Random();
        String ans = "";
        for (int i = 0; i < len; i++) {
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int
            ans = ans + numbers.charAt(random.nextInt(numbers.length()));
        }
        return ans;
    }
}
