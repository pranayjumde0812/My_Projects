package com.coderview.smartcontact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserSpecificController {

    @RequestMapping("/user/index")
    public String userDashboard(Model model) {

        model.addAttribute("dashboard", "USER - Dashboard");

        return "/normal/user-dashboard";
    }

    @RequestMapping("/admin/index")
    public String adminDashboard(Model model) {

        model.addAttribute("dashboard", "Admin - Dashboard");

        return "/admin/admin-dashboard";
    }

}
