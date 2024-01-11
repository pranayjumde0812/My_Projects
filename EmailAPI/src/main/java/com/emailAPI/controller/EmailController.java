package com.emailAPI.controller;

import com.emailAPI.model.EmailRequest;
import com.emailAPI.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    // handler for sending email
    @RequestMapping(value = "/send-email", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {

        System.out.println(emailRequest);

        boolean result = emailService.sendEmail(emailRequest.getSubject(), emailRequest.getMessage(), emailRequest.getTo());

        if (result) {

            return ResponseEntity.ok("Email Sent successfully...");

        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not send...");
        }


    }
}
