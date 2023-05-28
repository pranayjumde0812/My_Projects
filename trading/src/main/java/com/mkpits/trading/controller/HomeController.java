package com.mkpits.trading.controller;

import com.mkpits.trading.dto.response.TradingDataDto;
import com.mkpits.trading.service.TradingRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    TradingRegService tradingRegService;

    @GetMapping("/")
    public String home(Model model){

        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        List<TradingDataDto> tradingDataDtoListH2 = new ArrayList<>();

        model.addAttribute("trading",tradingRegService.getAllRegistrationData());

        return "dashboard";
    }

    @GetMapping("/registration-form")
    public String registerUserPage(Model model) {
        model.addAttribute("register", TradingDataDto.builder().build());
        return "registration-form";
    }

}
