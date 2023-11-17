package bank.management.system.database;

import bank.management.system.administration.AdministrationPage;
import java.util.Random;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {

    // GENERATING RANDOM PASSWORD:---
    public static String getPassword() {
        String SALTCHARS = "ABCDENOPQRSTUWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    // Encrypting Generated Random Password:
    public static String encryptPassword() {
        String hashedPassword, password;
        password = getPassword();
        hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword.substring(0, 7);
    }

    // Encrypting User-Defined Password For storing into Database:
    public static String encryptAdminPassword() {
        String hashedPassword, password;
        password = AdministrationPage.encryptPassword();
        hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword.substring(0, 7);
    }

}
