package com.bosonit.Ej15SpringSecurity.person.application;

import com.bosonit.Ej15SpringSecurity.exceptions.EntityNotFoundException;
import com.bosonit.Ej15SpringSecurity.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15SpringSecurity.person.infraestructure.controller.output.PersonOutputDto;

import java.util.List;

public interface PersonService {

    public PersonOutputDto addPerson(PersonInputDto personDtoInput) throws Exception;

    public PersonOutputDto getPersonById(Integer id) throws EntityNotFoundException;

    public List<PersonOutputDto> getAllPeople();

    public void deletePersonById(Integer id);

    public PersonOutputDto modifyPerson(PersonInputDto personDtoInput, Integer idPerson);
}
