package com.emailAPI.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    public boolean sendEmail(String subject, String message, String to) {

        boolean flag = false;

        // sender is constant
        String sender = "codersview08@gmail.com";

        // variable for gmail
        String host = "smtp.gmail.com";

        // get the system properties
        Properties properties = System.getProperties();
        System.out.println("Properties " + properties);

        // setting important information to properties object

        // setting host
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        // Step 1 : to get the session object...
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("codersview08@gmail.com", "xbjf edrh swhz ylwz");
            }
        });

        session.setDebug(true);

        // Step 2 : Compose the message [text,multimedia]
        MimeMessage mimeMessage = new MimeMessage(session);

        try {

            // from email
            mimeMessage.setFrom(sender);

            // adding recipient to message
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // adding subject to message
            mimeMessage.setSubject(subject);

            // adding text to message
            mimeMessage.setText(message);

            // send
            // Step 3 : send the message using Transport class

            Transport.send(mimeMessage);

            System.out.println("Send Successfully");

            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
