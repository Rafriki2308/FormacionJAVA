package com.bosonit.Ej7.crudvalidation.person.application;

import com.bosonit.Ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputFatherDto;

import java.util.List;

public interface PersonService {

    public PersonOutputDto addPerson(PersonInputDto personDtoInput) throws Exception;

    public PersonOutputFatherDto getPersonById(String id, String outputType) throws EntityNotFoundException;

    public List<PersonOutputFatherDto> getPersonByUser(String name, String outputType);

    public List<PersonOutputFatherDto> getAllPeople(String outputType);

    public void deletePersonById(String id);

    public PersonOutputDto modifyPerson(PersonInputDto personDtoInput);
}
