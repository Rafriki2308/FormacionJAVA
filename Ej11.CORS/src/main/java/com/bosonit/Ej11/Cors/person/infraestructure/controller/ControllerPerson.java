package com.bosonit.Ej11.Cors.person.infraestructure.controller;

import com.bosonit.Ej11.Cors.exceptions.UnprocessableEntityException;
import com.bosonit.Ej11.Cors.person.application.PersonServiceImpl;
import com.bosonit.Ej11.Cors.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej11.Cors.person.infraestructure.controller.input.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "https://codepen.io/de4imo/pen/VwMRENP")
public class ControllerPerson {

    @Autowired
    private PersonServiceImpl servicePersonRepository;

    @PostMapping("/addperson")
    public PersonOutputDto addPerson(@RequestBody PersonInputDto personDtoInput) throws UnprocessableEntityException {
        try {
            return servicePersonRepository.addPerson(personDtoInput);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/{id}")
    public PersonOutputDto getPersonById(@PathVariable String id){

            return servicePersonRepository.getPersonById(Integer.parseInt(id));
        }

    @GetMapping("/getall")
    public List<PersonOutputDto> getAllPeople(){return servicePersonRepository.getAllPeople();}

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable String id){
        servicePersonRepository.deletePersonById(Integer.parseInt(id));}

    @PutMapping("/{id}")
    public PersonOutputDto updatePerson(@RequestBody PersonInputDto personDtoInput, @PathVariable String id){
        return servicePersonRepository.modifyPerson(personDtoInput, Integer.parseInt(id));
    }

}
