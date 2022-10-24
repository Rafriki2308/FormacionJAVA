package com.bosonit.Ej13.crudvalidation.person.application;

import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.output.PersonOutputFatherDto;
import com.bosonit.Ej13.crudvalidation.exceptions.EntityNotFoundException;

import java.util.List;

public interface PersonService {

    public PersonOutputDto addPerson(PersonInputDto personDtoInput) throws Exception;

    public PersonOutputFatherDto getPersonById(String id, String outputType) throws EntityNotFoundException;

    public List<PersonOutputFatherDto> getPersonByUser(String name, String outputType);

    public List<PersonOutputFatherDto> getAllPeople(String outputType);

    public void deletePersonById(String id);

    public PersonOutputDto modifyPerson(PersonInputDto personDtoInput, String idPerson);
}
