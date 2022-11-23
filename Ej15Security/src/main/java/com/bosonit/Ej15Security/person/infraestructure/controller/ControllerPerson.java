package com.bosonit.Ej15Security.person.infraestructure.controller;


import com.bosonit.Ej15Security.person.application.PersonServiceImpl;
import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControllerPerson {

    @Autowired
    private PersonServiceImpl servicePersonRepository;

    @PostMapping("")
    public PersonOutputDto addPerson(@RequestBody PersonInputDto personDtoInput){

            return servicePersonRepository.addPerson(personDtoInput);
    }

    @GetMapping("/getPersonById/{id}")
    public PersonOutputDto getPersonById(@PathVariable String id){

            return servicePersonRepository.getPersonById(Integer.parseInt(id));
        }

    @GetMapping("/getPersonByUser/{username}")
    public List<PersonOutputDto> getPersonByName(@PathVariable String user){

        return servicePersonRepository.getPersonByUser(user);
    }

    @GetMapping("/all")
    public List<PersonOutputDto> getAllPeople(){return servicePersonRepository.getAllPeople();}

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable String id){
        servicePersonRepository.deletePersonById(Integer.parseInt(id));}

    @PutMapping("/{id}")
    public PersonOutputDto updatePerson(@RequestBody PersonInputDto personDtoInput, @PathVariable String id){
        return servicePersonRepository.modifyPerson(personDtoInput, Integer.parseInt(id));
    }

}
