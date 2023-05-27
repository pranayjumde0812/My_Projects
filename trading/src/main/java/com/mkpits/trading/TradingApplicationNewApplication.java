package com.mkpits.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TradingApplicationNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingApplicationNewApplication.class, args);
	}

}
