package com.mkpits.trading.controller;

import com.mkpits.trading.dto.request.RegistrationData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/regform")
    public String registrationForm(Model model){

        model.addAttribute("registrationForm",new RegistrationData());
        return "registration-form";
    }


    @PostMapping("/viewform")
    public ModelAndView registrationDetails(@ModelAttribute RegistrationData registrationData,Model model){

        System.out.println(registrationData.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view-form");
        modelAndView.addObject("finalDetails",registrationData);
        model.addAttribute("message","You have login successfully "+registrationData.getFirstName()+" "+ registrationData.getLastName());

        return modelAndView ;
    }
}
