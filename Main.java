
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author kausik ayinala
 */
public class Main {
    
    public static void main(String args[]) throws NoSuchAlgorithmException{
        String CommonPassword = "";
        String Salt = "";
        String SiteName="";
        String Email = "";
        
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
        byte[] messageDigest = md.digest((CommonPassword+Salt+SiteName+Email).getBytes());
        
        final String Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*(){}:;<>?/.,'[]-+=|";
        final String ShuffledChars = "q[sK*HY|+Eo?8SMxA9ltGFwc4RCeNIy/n)!5D;3azB.b}fd>@7<i-QTgLX{=:($#%jPWJ6v^VUh'21&m,]OZukp0r";
        String GeneratedPassword ="";
        
        for(int i=0;i<messageDigest.length/2;i++){
            int random = Math.abs(messageDigest[i*2] | messageDigest[(i*2)+1] << 8);
            GeneratedPassword += ShuffledChars.charAt(random%ShuffledChars.length());
        }
        System.out.println(GeneratedPassword);
         
    }
}
