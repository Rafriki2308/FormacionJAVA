package com.bosonit.Ej15Security;

import com.bosonit.Ej15Security.person.application.PersonServiceImpl;
import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.role.application.RoleServiceImp;
import com.bosonit.Ej15Security.role.infrastructure.controller.Input.RoleInputDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@Slf4j
public class Ej15Security implements CommandLineRunner {

	@Autowired
	private PersonServiceImpl personService;

	@Autowired
	private RoleServiceImp roleServiceImp;

	public static void main(String[] args) {
		SpringApplication.run(Ej15Security.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info(String.valueOf(roleServiceImp.addRole(new RoleInputDto("ROLE_USER"))));
		log.info(String.valueOf(roleServiceImp.addRole(new RoleInputDto("ROLE_ADMIN"))));
		log.info(String.valueOf(roleServiceImp.addRole(new RoleInputDto("ROLE_SUPER_ADMIN"))));



		PersonInputDto personInputDto = new PersonInputDto(
				"rafael",
				"password",
				"Rafael",
				"Rafael",
				"Rafael.martinez@bosonit.com",
				"Rafael@gmail.com",
				"Polopos",
				true,
				new Date(),
				"image.png",
				new Date());

		PersonInputDto personInputDto2 = new PersonInputDto(
				"deadpool",
				"password",
				"deadpool",
				"Rafael",
				"Rafael.martinez@bosonit.com",
				"Rafael@gmail.com",
				"Polopos",
				true,
				new Date(),
				"image.png",
				new Date());
		log.info(String.valueOf(personService.addPerson(personInputDto)));
		log.info(String.valueOf(personService.addPerson(personInputDto2)));

		log.info(String.valueOf(roleServiceImp.addRoleToPerson("rafael","ROLE_ADMIN")));
		log.info(String.valueOf(roleServiceImp.addRoleToPerson("deadpool","ROLE_USER")));
	}

}
