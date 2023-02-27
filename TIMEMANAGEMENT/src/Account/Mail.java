/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import java.sql.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author DELL
 */
public class Mail {
    
   
    
    public void SendMailto (String toUserMail, String code) throws Exception
    {
        //String toUserMail="hang2312@gmail.com";
        Properties p = System.getProperties();
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        
        String fromUser = "schess.uit@gmail.com";
        String fromUserPassword = "lllxnqvgagpxtptu";
        
        Session newSession = Session.getDefaultInstance(p,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(fromUser,fromUserPassword);
            }
        });
        
        Message message = prepareMessage(newSession, fromUser, toUserMail, code);
        Transport.send(message);
        //System.out.print("successful");
    }
   
    
    
    private Message prepareMessage(Session session, String fromUser, String toUser, String code){
        try{
            String emailBody = "Mã của bạn: " + code;
            
            String emailSubject = "Mã xác nhận";
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromUser));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toUser));
            message.setSubject(emailSubject);
            message.setText(emailBody);
            return message;
        }catch(Exception ex)
        {
            System.out.print("Lỗi ở tạo mess" + ex);
        }
        return null;
    }
    
}
