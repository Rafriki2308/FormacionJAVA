package com.bosonit.ServiceLocatorFactoryBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (value={"com.bosonit.MotoService", "com.bosonit.ServiceLocatorFactoryBean"})
public class ServiceLocatorFactoryBeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceLocatorFactoryBeanApplication.class, args);
	}

}
