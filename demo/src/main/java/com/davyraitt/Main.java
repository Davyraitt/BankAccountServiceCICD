package com.davyraitt;

import org.apache.catalina.Engine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication application =  new SpringApplication(Main.class);
		//application.setAdditionalProfiles("h2");
		application.setAdditionalProfiles("default");
		application.run(args);
	}


}
