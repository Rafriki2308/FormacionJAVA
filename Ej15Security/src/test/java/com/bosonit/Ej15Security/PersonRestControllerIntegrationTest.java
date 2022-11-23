package com.bosonit.Ej15Security;

import com.bosonit.Ej15Security.person.domain.Person;
import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej15Security.person.infraestructure.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest("SpringBootTest.WebEnvironment.MOCK,classes = Ej14TestingApplication.class")
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class PersonRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository pR;
    @Autowired
    ObjectMapper objectMapper;

    private Date date = new Date();

    private PersonInputDto personInputDto;

    private PersonInputDto personInputDtoModified;
    private PersonInputDto personInputDtoBadFormed;

    private List<PersonOutputDto> peopleOutputDto;

    private PersonOutputDto personOutputDto;


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
        personInputDtoModified = new PersonInputDto(
                "usuario2",
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

    @AfterEach
    void deleteBd() throws Exception{
        pR.deleteAll();
    }

    @Test
    void shouldAddPerson() throws Exception {

        mvc.perform(post("/persona").contentType("application/json")
                        .content(objectMapper.writeValueAsString(personInputDto)))
                .andExpect(status().isOk());

    }

    @Test
    void whenAddPersonBadFormedThrowsException() throws Exception {

        mvc.perform(post("/persona").contentType("application/json")
                        .content(objectMapper.writeValueAsString(personInputDtoBadFormed)))
                .andExpect(status().isUnprocessableEntity());

    }

    @Test
    public void souldFetchAllUsers() throws Exception {

        mvc.perform(delete("/persona/{id}", "2")
                        .contentType("application/json"));

        mvc.perform(post("/persona").contentType("application/json")
                .content(objectMapper.writeValueAsString(personInputDto)));

        mvc.perform(get("/persona/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    void whenAskForAllPeopleButNobodyThrowsException() throws Exception {

        mvc.perform(get("/persona/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void souldFetchUsersByName() throws Exception {

        mvc.perform(post("/persona").contentType("application/json")
                .content(objectMapper.writeValueAsString(personInputDto)));


        mvc.perform(get("/persona/getPersonByUser/{usuario}", "usuario")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].username", Matchers.is("usuario")));

    }

    @Test
    public void whenAskPersonByNameButNamePersonNotExistsThrowException() throws Exception {


        mvc.perform(get("/persona/getPersonByUser/{usuario}", "usuario")
                        .contentType("application/json"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void souldFetchUsersById() throws Exception {

        mvc.perform(post("/persona").contentType("application/json")
                .content(objectMapper.writeValueAsString(personInputDto)));

        mvc.perform(get("/persona/getPersonById/{id}", "6")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(6)));
    }

    @Test
    public void whenAskPersonByIdButIdPersonNotExistsThrowException() throws Exception {

        mvc.perform(get("/persona/getPersonById/{id}", "1")
                        .contentType("application/json"))
                .andExpect(status().isNotFound());

    }

    @Test
    public void souldUpdatePerson() throws Exception {

        mvc.perform(post("/persona").contentType("application/json")
                .content(objectMapper.writeValueAsString(personInputDto)));

        mvc.perform(put("/persona/{id}", "3")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(personInputDtoModified)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", Matchers.is("usuario2")));
    }

    @Test
    public void whenAskUpdatePersonByIdAndPersonNotExistsThrowException() throws Exception {

        mvc.perform(put("/persona/{id}", "1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(personInputDtoModified)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void souldDeletePerson() throws Exception {
        mvc.perform(post("/persona").contentType("application/json")
                .content(objectMapper.writeValueAsString(personInputDto)));

        mvc.perform(delete("/persona/{id}", "5")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenAskDeletePersonByIdButPersonNotExistsThrowException() throws Exception {

        mvc.perform(delete("/persona/{id}", "1")
                        .contentType("application/json"))
                .andExpect(status().isNotFound());
    }


}
