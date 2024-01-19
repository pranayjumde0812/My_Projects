package com.EmailApi.email.controller;


import com.EmailApi.email.model.EmailRequest;
import com.EmailApi.email.service.EmailServiceImpl;
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
    private EmailServiceImpl emailService;

    @RequestMapping(value = "/send-email", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {

        System.out.println(emailRequest);

        boolean status = emailService.sendEmail(emailRequest.getSubject(), emailRequest.getMessage(), emailRequest.getRecipient());

        if (status) {

            return ResponseEntity.ok("Email send successfully");

        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

        }

    }
}
