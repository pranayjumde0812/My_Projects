package com.coderview.smartcontact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserSpecificController {

    @RequestMapping("/home")
    public String userDashboard(Model model) {

        model.addAttribute("dashboard", "USER - Dashboard");

        return "normal/user-dashboard";
    }

}
