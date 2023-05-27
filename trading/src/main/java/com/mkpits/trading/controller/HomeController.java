package com.mkpits.trading.controller;

import com.mkpits.trading.dto.response.TradingDataDto;
import com.mkpits.trading.service.TradingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    public TradingDataService tradingDataService;

    @GetMapping("/")
    public String home(Model model){

        TradingDataDto tradingDataDto = new TradingDataDto();

        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        List<TradingDataDto> tradingDataDtoList = tradingDataService.getTradingData();

        model.addAttribute("trading",tradingDataDtoList);

        return "dashboard";
    }

}
