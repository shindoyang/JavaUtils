package shindo.Java.mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class EmailService {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        emailService.send();
    }
    /**
     * 发送邮件
     * */
    public void send()
    {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "mail.ut.cn"); //
        props.put("mail.smtp.auth", "false");
        props.put("mail.debug", "true");
//        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "25");
//        props.put("mail.smtp.socketFactory.port", "25");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "true");
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.socketFactory", sf);
        } catch (GeneralSecurityException e1) {
            e1.printStackTrace();
        }

        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mail.ut.cn", "password");
            }
        });

        mailSession.setDebug(false); // Enable the debug mode
        Message msg = new MimeMessage( mailSession );
        try {
            msg.setFrom( new InternetAddress( "yanggeng@ut.cn" ) );
            msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse("yanggeng@ut.cn") );
            msg.setSubject( "hello world, shindo" );
            msg.setText( "Hello from my first e-mail sent with JavaMail" );
            Transport.send( msg );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
