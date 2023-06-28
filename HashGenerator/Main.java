import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static String creatHash(String text) {
        final StringBuilder hexString = new StringBuilder();
        try{
            // Select your type of Hash here!
            final MessageDigest digest = MessageDigest.getInstance("MD5");
            final byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            for (byte b : hash) {
                final String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
        } catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String text = sc.nextLine();
            System.out.println(creatHash(text));
        }
    }
}
