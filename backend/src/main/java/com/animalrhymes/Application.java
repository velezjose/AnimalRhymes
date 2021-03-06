package com.animalrhymes;

import com.animalrhymes.engine.RhymeEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		RhymeEngine rhymeEngine = RhymeEngine.init();
		System.out.println("Waiting for requests...\n");
	}
}
