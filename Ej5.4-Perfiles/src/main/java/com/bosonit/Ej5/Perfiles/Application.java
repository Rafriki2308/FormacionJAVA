package com.bosonit.Ej5.Perfiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${environment}")
	private String environment;

	@Value("${bd.url}")
	private String bdUrl;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(environment);
		System.out.println(bdUrl);
	}
}
