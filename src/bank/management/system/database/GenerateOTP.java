package bank.management.system.database;

import java.util.Random;

public class GenerateOTP {

    public static String generateOTPForEmailVerification() {
        int len = 4;
        System.out.println("Generating OTP using random() : ");
        System.out.print("You OTP is : ");
        // Using numeric values
        String numbers = "0123456789";

        // Using random method
        Random rndm_method = new Random();
        String ans = "";
        for (int i = 0; i < len; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            ans = ans + numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return ans;
    }
}
