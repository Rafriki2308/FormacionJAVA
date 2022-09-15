package com.bosonit.ej5.commandlinerunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Arranca mi aplicación...");
	}

	@PostConstruct
	public void run1(){
		System.out.println("Hola desde clase inicial");
	}

	@Bean
	public void run2()
	{
		System.out.println("Hola desde clase secundaria");
	}

	@Bean
	CommandLineRunner run3() {
		return args ->
		{
			System.out.println("Soy la tercera clase" + args.toString());
		};
	}

}
