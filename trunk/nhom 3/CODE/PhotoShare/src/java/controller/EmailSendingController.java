/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Admin
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSendingController {

    
    public void SendMailRegsiter(String email, String password) {
        final String usernamesr = "webphotoshare1@gmail.com";
        final String passwordsr = "dang12345";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usernamesr, passwordsr);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(usernamesr));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("confirm successful registration !");
			message.setText("Dear Mail Crawler !"
				+ "\n\n greeting you have successfully registered an account at photoshare.com!"
                                +"\nInformation your account:"
                                +"\n email: "+email
                                +"\nPassword:"+password
                                +"\nPlease do not reply to this email. Thanks!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
                
    }
  
    
}
