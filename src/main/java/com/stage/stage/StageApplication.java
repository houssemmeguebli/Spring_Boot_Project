package com.stage.stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.stage.controller","com.stage.service"})

public class StageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StageApplication.class, args);
		System.out.println("Projet Stage");
		
	}

}
