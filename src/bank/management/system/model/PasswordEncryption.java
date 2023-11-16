package bank.management.system.model;
import bank.management.system.accountRegistration.AccountRegisteration;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {
    public static String encryptPassword(){
         String hashedPassword, password;
         password =  AccountRegisteration.getPassword();
         hashedPassword =BCrypt.hashpw(password, BCrypt.gensalt());
         return hashedPassword.substring(0, 7);
    }
}
