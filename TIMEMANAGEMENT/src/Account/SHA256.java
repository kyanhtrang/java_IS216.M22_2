/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

/**
 *
 * @author DELL
 */
public class SHA256 {
    public SHA256(){};
    public String encryptThisString(String input) 
    { 
        try{
            // getInstance() method is called with algorithm SHA-512 
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Chuyển đổi mảng byte sang BigInteger
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Chuyển đổi message digest sang dạng hex 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // Trả về kết quả
            return hashtext; 
        } 
        catch(Exception ex)
        {
            System.out.print(ex);
            return null;
        }
    } 
}
