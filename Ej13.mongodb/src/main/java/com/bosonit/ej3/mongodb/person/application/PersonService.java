package com.bosonit.ej3.mongodb.person.application;


import com.bosonit.ej3.mongodb.exceptions.EntityNotFoundException;
import com.bosonit.ej3.mongodb.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.ej3.mongodb.person.infraestructure.controller.output.PersonOutputDto;

import java.util.List;

public interface PersonService {

    public PersonOutputDto addPerson(PersonInputDto personDtoInput) throws Exception;

    public PersonOutputDto getPersonById(String id) throws EntityNotFoundException;

    public List<PersonOutputDto> getAllPeople();

    public void deletePersonById(String id);

    public PersonOutputDto modifyPerson(PersonInputDto personDtoInput, String idPerson);
}
