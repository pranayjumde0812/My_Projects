package com.EmailApi.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender mailSender;


    public boolean sendEmail(String subject,
                             String message,
                             String recipient) {

        boolean flag = false;

        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom("coderview08@gmail.com");
            mailMessage.setTo(recipient);
            mailMessage.setSubject(subject);
            mailMessage.setText(message);

            mailSender.send(mailMessage);

            System.out.println("Mail sent successfully.....");

            flag = true;

        } catch (Exception exception) {

            exception.printStackTrace();

        }

        return flag;
    }

}
