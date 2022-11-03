package message;

import java.util.Properties;

import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.*;
public class SendEmail {

    public static void sendMessage(String error) throws Exception{

        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        properties.put("mail.smtp.host","smtp.ukr.net");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.Enable","true");
        properties.put("mail.smtp.user","solomiialesiv@ukr.net");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("solomiialesiv@ukr.net", "***************");
            }
        };

        Session session = Session.getDefaultInstance(properties,auth);
        System.out.println("Session created");

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("solomiialesiv@ukr.net"));
        message.setReplyTo(InternetAddress.parse("solomiialesiv@ukr.net", false));
        message.setSubject("The critical error occurred","ANSI");
        message.setText(error,"ANSI");

        message.setRecipient(Message.RecipientType.TO,new InternetAddress("solomiialesiv@ukr.net"));
        Transport.send(message);
        System.out.println("Message was sent successfully...");

    }
}
