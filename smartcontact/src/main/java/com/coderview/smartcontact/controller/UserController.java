package com.coderview.smartcontact.controller;

import com.coderview.smartcontact.helper.Message;
import com.coderview.smartcontact.model.User;
import com.coderview.smartcontact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // Handler for register user
    @PostMapping("register")
    public String registerNewUser(@ModelAttribute("user") User user,
                                  @RequestParam(value = "agreement",
                                          defaultValue = "false") boolean agreement,
                                  Model model,
                                  HttpSession session) {

        try {
            if (!agreement) {
                System.out.println("You have not agreed the terms and conditions");
                throw new Exception("You have not agreed the terms and conditions");

//                model.addAttribute("errorMsg", "Please select terms and condition");
//                return "signup";
            }

             User saveUser = userService.registerUser(user);

            model.addAttribute("user", new User());
            session.setAttribute("message",new Message("Successfully Registered!!! ","alert-success"));

            return "login";

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message",new Message("Something went wrong!!! "+e.getMessage(),"alert-danger"));

            return "signup";
        }

    }

}
