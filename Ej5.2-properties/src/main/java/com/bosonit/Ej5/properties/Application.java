package com.bosonit.Ej5.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("classpath:foo.properties.yml")
public class Application implements EnvironmentAware, CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${greeting}")
	private String line1;

	@Value("${my.number}")
	private String line2;

	@Value("${new.property:new.property no tiene valor}")
	private String line3;

	private String line4;


	@Override
	public void run(String... args) throws Exception {
		System.out.println("El valor de greeting es: (" + line1 + ")");
		System.out.println("El valor de my.number es: (" + line2 + ")");
		System.out.println("El valor de new.property es: (" + line3 + ")");
		System.out.println(line4);
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.line4 = environment.getProperty("greeting");
	}
}
