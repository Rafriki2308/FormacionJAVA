package com.bosonit.Ej7.crud.Services;

import com.bosonit.Ej7.crud.Model.Person;
import com.bosonit.Ej7.crud.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;

@Service
public class ManagerRepository {

    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person){
        return personRepository.add(person);
    }

    public Person getPersonById(String id){

        return personRepository.getPersonById(Integer.parseInt(id));
    }

    public Person modifiedPersonById(String id, Person person){
        long finalId =(long)Integer.parseInt(id);
        return personRepository.modifyPersonById(finalId, person);
    }

    public Person getPersonByName(String name){
        try {
            return personRepository.getPersonByName(name);
        } catch (NoSuchObjectException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean deletePersonById(String id){
        return personRepository.deletePersonById(Integer.parseInt(id));
    }
}
