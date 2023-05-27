package com.udemy100steps.spring.learnspringframework.enterprise.example.web;

import com.udemy100steps.spring.learnspringframework.enterprise.example.bussiness.BussinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyWebController {
    @Autowired
    private BussinessService getBussinessService;

//    @Autowired
    public MyWebController(BussinessService getBussinessService) {
//        super();
        System.out.println("Constructor based In MyWebController");
        this.getBussinessService = getBussinessService;
    }

    public long returnValueFromBussinessService(){

        return  getBussinessService.calulateSum();
    }
}

