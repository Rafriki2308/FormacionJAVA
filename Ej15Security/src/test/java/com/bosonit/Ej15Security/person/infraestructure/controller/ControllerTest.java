package com.bosonit.Ej15Security.person.infraestructure.controller;

import com.bosonit.Ej15Security.person.application.PersonServiceImpl;
import com.bosonit.Ej15Security.person.domain.Person;
import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ControllerPerson.class)
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonServiceImpl personServiceImp;

    @InjectMocks
    private ControllerPerson underTest;

    private PersonInputDto personInputDto;
    private PersonInputDto personInputDtoBadFormed;

    private List<PersonOutputDto> peopleOutputDto;

    private PersonOutputDto personOutputDto;

    private Date date = new Date();

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        personInputDto = new PersonInputDto(
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
                date
        );
        personInputDtoBadFormed = new PersonInputDto(
                "",
                "password",
                "name",
                "surname",
                "comany@email.com",
                "personal@emial.com",
                "city",
                true,
                date,
                "image_url",
                date
        );
        Person person = new Person(personInputDto);
        personOutputDto = new PersonOutputDto(person);
        peopleOutputDto = new ArrayList<>();
        this.peopleOutputDto.add(personOutputDto);

    }

    @Test
    void shouldAddPerson() throws Exception {


        when(personServiceImp.addPerson(personInputDto)).thenReturn(personOutputDto);

        mvc.perform(post("/persona").contentType("application/json")
                        .content(objectMapper.writeValueAsString(personInputDto)))
                .andExpect(status().isOk());

    }


    @Test
    public void souldFetchAllUsers() throws Exception {

        when(personServiceImp.getAllPeople()).thenReturn(peopleOutputDto);


        mvc.perform(get("/persona/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void souldFetchUsersByName() throws Exception {


        when(personServiceImp.getPersonByName("usuario")).thenReturn(peopleOutputDto);


        mvc.perform(get("/persona/getPersonByUser/{usuario}", "usuario")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void souldFetchUsersById() throws Exception {

        when(personServiceImp.getPersonByName("1")).thenReturn(peopleOutputDto);

        mvc.perform(get("/persona/getPersonById/{idRole}", "1")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void souldDeletePerson() throws Exception {

        mvc.perform(delete("/persona/{idRole}", "1")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void souldUpdatePerson() throws Exception {

        when(personServiceImp.modifyPerson(personInputDto, Integer.parseInt("1"))).thenReturn(personOutputDto);

        mvc.perform(put("/persona/{idRole}", "1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(personInputDto)))
                .andExpect(status().isOk());
    }




}



