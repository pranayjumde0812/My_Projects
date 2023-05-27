package com.udemy100steps.spring.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperContraGame implements GamingConsole {

    public void up(){
        System.out.println(" SuprContraGame JUMP");
    }
    public void down(){
        System.out.println("SuprContraGame Down");
    }
    public void left(){
        System.out.println("SuprContraGame STOP");
    }
    public void right(){
        System.out.println("SuperContraGame ACCELERATE");
    }
}
