package com.udemy100steps.spring.learnspringframework.enterprise.example.bussiness;

import com.udemy100steps.spring.learnspringframework.enterprise.example.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BussinessService {

    @Autowired
   private DataService getDataService;

//    Constructor based dependency injection

//   @Autowired
    public BussinessService(DataService getDataService) {
//       super();
       System.out.println("Constructor based dependency injection");
        this.getDataService = getDataService;
    }

    //  SETTER INJECTION TYPE
//   @Autowired
//    public void setGetDataService(DataService getDataService) {
//       System.out.println("SETTER Injection");
//        this.getDataService = getDataService;
//    }

    public  long calulateSum(){
       List <Integer> data= getDataService
               .getData();

       return data.stream().reduce(Integer::sum).get();
   }
}

