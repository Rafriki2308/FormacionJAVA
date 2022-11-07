package com.bosonit.Ej14Testing.person.infraestructure.repository;


import com.bosonit.Ej14Testing.person.domain.Person;

import com.bosonit.Ej14Testing.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej14Testing.person.infraestructure.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void whenAskForFindByUserItReturnListOfUser() {

        Date date = new Date();
        Date date2 = new Date();
        PersonInputDto personTestDto = new PersonInputDto(
                "usuario",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date2
        );

        Person personSavedTest = underTest.save(new Person(personTestDto));
        Integer idResult = personSavedTest.getId();
        Person personResult = underTest.findPersonaById(idResult);

        assertThat(personSavedTest).isEqualTo(personResult);
    }

    @Test
    public void whenAskForUserByNameItReturnsListOfUsers(){

        Date date = new Date();
        Date date2 = new Date();
        PersonInputDto personTestDto = new PersonInputDto(
                "usuario",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date2
        );
        Person personSavedTest = underTest.save(new Person(personTestDto));
        List<Person> peopleToTest = new ArrayList<>();
        peopleToTest.add(personSavedTest);

        List<Person> peopleObtain = new ArrayList<>();
        peopleObtain = underTest.findByUser(personSavedTest.getUser());

        assertThat(peopleToTest).isEqualTo(peopleObtain);
    }
}