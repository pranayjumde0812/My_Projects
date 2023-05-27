package com.udemy100steps.spring.learnspringframework.enterprise.example.data;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class DataService {

    public List<Integer> getData(){
        return Arrays.asList(10,30,83,97);
    }
}
