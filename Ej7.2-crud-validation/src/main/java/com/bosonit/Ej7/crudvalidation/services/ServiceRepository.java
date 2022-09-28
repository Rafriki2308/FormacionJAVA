package com.bosonit.Ej7.crudvalidation.services;

import com.bosonit.Ej7.crudvalidation.exception.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.model.Person;
import com.bosonit.Ej7.crudvalidation.personDto.PersonDtoInput;
import com.bosonit.Ej7.crudvalidation.personDto.PersonDtoOutput;
import com.bosonit.Ej7.crudvalidation.personDto.PersonDtoResponse;
import com.bosonit.Ej7.crudvalidation.repository.PersonRepository;
import com.bosonit.Ej7.crudvalidation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRepository {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonDtoResponse personDtoResponse;

    @Autowired
    private Validator validator;

    public PersonDtoOutput addPerson(PersonDtoInput personDtoInput) throws Exception {
        if(validator.checkPersonDtoImput(personDtoInput)){
            personRepository.save(new Person(personDtoInput));
        }
        return new PersonDtoOutput(personDtoInput);
    }

    public PersonDtoOutput getPersonById(Integer id) throws EntityNotFoundException {
        if(personRepository.findPersonaById(id)==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        return new PersonDtoOutput(personRepository.findPersonaById(id));
    }

    public PersonDtoOutput getPersonByUser(String name){
        if(personRepository.findByUser(name)==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        return new PersonDtoOutput(personRepository.findByUser(name));
    }

    public List<PersonDtoOutput> getAllPeople(){
        return personDtoResponse.mappingPersonToPersonDtoOutput(personRepository.findAll());
    }
    public void deletePersonById(Integer id){
        if(personRepository.findPersonaById(id)==null) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        personRepository.delete(personRepository.findPersonaById(id));
    }

    public PersonDtoOutput modifyPersonById(PersonDtoInput personDtoInput){
        personRepository.save(new Person(personDtoInput));
        return new PersonDtoOutput(personDtoInput);
    }
}
