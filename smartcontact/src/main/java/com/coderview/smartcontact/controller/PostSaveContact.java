package com.coderview.smartcontact.controller;

import com.coderview.smartcontact.model.Contact;
import com.coderview.smartcontact.model.User;
import com.coderview.smartcontact.repository.UserRepo;
import com.coderview.smartcontact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class PostSaveContact {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add-contact")
    public String saveContact(@ModelAttribute("contact") Contact contact,
                              Principal principal,
                              Model model) {

        String userName = principal.getName();
        System.out.println(userName);

        // fetch user by username
        User user = userService.getUserByUsername(userName);
        System.out.println(user);

        model.addAttribute("user", user);




        // This is bidirectional mapping
        // set user in contacts first
        contact.setUser(user);

        // update the user with new contact added in it
        user.getContacts().add(contact);

        userRepo.save(user);




        return "normal/add-contacts";
    }
}
