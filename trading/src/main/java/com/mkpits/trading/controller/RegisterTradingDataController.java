package com.mkpits.trading.controller;

import com.mkpits.trading.dto.response.TradingDataDto;
import com.mkpits.trading.service.RegisterTradingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterTradingDataController {

    @Autowired
    RegisterTradingDataService registerTradingDataService;

    @PostMapping("/registration-form")
    public String registerDataDetails(@ModelAttribute("addedList") TradingDataDto tradingDataDto) {
        registerTradingDataService.getRegistrationData(tradingDataDto);

        return "redirect:/dashboard";
    }

}
