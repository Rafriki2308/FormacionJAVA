package com.bosonit.Ej10.Dockerizacionaplicacion.person.application;

import com.bosonit.Ej10.Dockerizacionaplicacion.exceptions.EntityNotFoundException;
import com.bosonit.Ej10.Dockerizacionaplicacion.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej10.Dockerizacionaplicacion.person.infraestructure.controller.input.output.PersonOutputDto;

import java.util.List;

public interface PersonService {

    public PersonOutputDto addPerson(PersonInputDto personDtoInput) throws Exception;

    public PersonOutputDto getPersonById(Integer id) throws EntityNotFoundException;

    public List<PersonOutputDto> getAllPeople();

    public void deletePersonById(Integer id);

    public PersonOutputDto modifyPerson(PersonInputDto personDtoInput, Integer idPerson);
}
