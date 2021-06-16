package sample;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendEmail {

    public static void send(String to, String msg) {
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        String from = "programmingtutorial1.0@gmail.com";
        String password = "2018331008";

        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        //compose message
        try {
            Message message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Confirmation Code");
            //message.setText("Your code is "+code);
            message.setContent( msg,"text/html");
            Address address = new InternetAddress(session.getProperty("mail.from"), session.getProperty("mail.from.alias"), "UTF8");
            message.setFrom(address);

            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            System.out.println("sender: " + e.toString());
            throw new RuntimeException(e);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

    }

}

