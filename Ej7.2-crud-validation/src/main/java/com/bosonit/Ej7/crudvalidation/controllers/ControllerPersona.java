package com.bosonit.Ej7.crudvalidation.controllers;

import com.bosonit.Ej7.crudvalidation.exception.EntityNotFoundException;
import com.bosonit.Ej7.crudvalidation.exception.UnprocessableEntityException;
import com.bosonit.Ej7.crudvalidation.personDto.PersonDtoInput;
import com.bosonit.Ej7.crudvalidation.personDto.PersonDtoOutput;
import com.bosonit.Ej7.crudvalidation.services.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerPersona {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping("/persona")
    public PersonDtoOutput addPerson(@RequestBody PersonDtoInput personDtoInput) throws UnprocessableEntityException {
        try {
            return serviceRepository.addPerson(personDtoInput);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/persona/{id}")
    public PersonDtoOutput getPersonById(@PathVariable Integer id){

            return serviceRepository.getPersonById(id);
        }

    @GetMapping("/persona/user/{user}")
    public PersonDtoOutput getPersonByUser(@PathVariable String user){return serviceRepository.getPersonByUser(user);}

    @GetMapping("persona/all")
    public List<PersonDtoOutput> getAllPeople(){return serviceRepository.getAllPeople();}

    @DeleteMapping("persona/{id}")
    public void deletePersonById(@PathVariable Integer id){serviceRepository.deletePersonById(id);}

    @PutMapping("/persona")
    public PersonDtoOutput updatePerson(@RequestBody PersonDtoInput personDtoInput){
        return serviceRepository.modifyPersonById(personDtoInput);
    }

}
