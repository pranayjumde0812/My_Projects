package com.udemy100steps.spring.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {

    public void up(){
        System.out.println("JUMP");
    }
    public void down(){
        System.out.println("DOWN IN THE HOLE");
    }
    public void left(){
        System.out.println("STOP");
    }
    public void right(){
        System.out.println("ACCELERATE");
    }
}
