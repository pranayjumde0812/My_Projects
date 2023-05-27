package com.udemy100steps.spring.learnspringframework;

import com.udemy100steps.spring.learnspringframework.enterprise.example.web.MyWebController;
import com.udemy100steps.spring.learnspringframework.game.GameRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {

//		MarioGame game=new MarioGame();

//		SuprContraGame game=new SuprContraGame();

//		PacmanGame game=new PacmanGame();

//		GamingConsole game=new MarioGame();   //1
//		GameRunner runner=new GameRunner(game);   //2

		ConfigurableApplicationContext context
				= SpringApplication.run(LearnSpringFrameworkApplication.class, args);

		GameRunner runner= context.getBean(GameRunner.class);
		runner.run();

		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBussinessService());
	}

}
