package com.bosonit.Ej7.crudvalidation.Services;

import com.bosonit.Ej7.crudvalidation.Model.Person;
import com.bosonit.Ej7.crudvalidation.PersonDto.PersonDtoInput;
import com.bosonit.Ej7.crudvalidation.PersonDto.PersonDtoOutput;
import com.bosonit.Ej7.crudvalidation.PersonDto.PersonDtoResponse;
import com.bosonit.Ej7.crudvalidation.Repository.PersonRepository;
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

    public PersonDtoOutput getPersonById(Integer id){
        return new PersonDtoOutput(personRepository.findPersonaById(id));
    }

    public PersonDtoOutput getPersonByUser(String name){
        return new PersonDtoOutput(personRepository.findByUser(name));
    }

    public List<PersonDtoOutput> getAllPeople(){
        return personDtoResponse.mappingPersonToPersonDtoOutput(personRepository.findAll());
    }
    public void deletePersonById(Integer id){
        personRepository.delete(personRepository.findPersonaById(id));
    }

    public PersonDtoOutput modifyPersonById(PersonDtoInput personDtoInput){
        personRepository.save(new Person(personDtoInput));
        return new PersonDtoOutput(personDtoInput);
    }
}
