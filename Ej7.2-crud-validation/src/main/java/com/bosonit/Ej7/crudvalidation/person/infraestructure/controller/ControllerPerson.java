package com.bosonit.Ej7.crudvalidation.person.infraestructure.controller;

import com.bosonit.Ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej7.crudvalidation.person.application.PersonServiceImpl;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputFatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControllerPerson {

    @Autowired
    private PersonServiceImpl servicePersonRepository;

    @PostMapping("")
    public PersonOutputDto addPerson(@RequestBody PersonInputDto personDtoInput) throws UnprocessableEntityException {
        try {
            return servicePersonRepository.addPerson(personDtoInput);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/{id}")
    public Object getPersonById(@PathVariable String id, @RequestParam String outputType){

            return servicePersonRepository.getPersonById(id, outputType);
        }

    @GetMapping("/user/{user}")
    public List<PersonOutputFatherDto> getPersonByUser(@PathVariable String user, @RequestParam String outputType) {
        return servicePersonRepository.getPersonByUser(user, outputType);
    }

    @GetMapping("/all")
    public List<PersonOutputFatherDto> getAllPeople(@RequestParam String outputType){return servicePersonRepository.getAllPeople(outputType);}

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable String id){
        servicePersonRepository.deletePersonById(id);}

    @PutMapping("/{id}")
    public PersonOutputDto updatePerson(@RequestBody PersonInputDto personDtoInput, @PathVariable String id){
        return servicePersonRepository.modifyPerson(personDtoInput, id);
    }

}
