package com.bosonit.Ej13.crudvalidation.person.infraestructure.controller;

import com.bosonit.Ej13.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej13.crudvalidation.person.application.PersonServiceImpl;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.output.PersonOutputFatherDto;
import com.bosonit.Ej13.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputFullDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Object getPersonById(@PathVariable String id, @RequestParam String outputType) {

        return servicePersonRepository.getPersonById(id, outputType);
    }

    @GetMapping("/user/{user}")
    public List<PersonOutputFatherDto> getPersonByUser(@PathVariable String user, @RequestParam String outputType) {
        return servicePersonRepository.getPersonByUser(user, outputType);
    }

    @GetMapping("/all")
    public List<PersonOutputFatherDto> getAllPeople(@RequestParam String outputType) {
        return servicePersonRepository.getAllPeople(outputType);
    }

    @GetMapping("/professor/{id}")
    public ProfessorOutputFullDto getProffesorById(@PathVariable String id) {
        return servicePersonRepository.getProffesorUsingFeign(id);
    }

    @GetMapping("/greaterThan/user")
    public List<PersonOutputFatherDto> getPeopleGreaterThanUser(@RequestParam String user) {
        return servicePersonRepository.getGreaterPeopleByUser(user);
    }

    @GetMapping("/lessThan/user")
    public List<PersonOutputFatherDto> getPeopleLessThanUser(@RequestParam String user) {
        return servicePersonRepository.getLessPeopleByUser(user);
    }

    @GetMapping("/greaterThan/name")
    public List<PersonOutputFatherDto> getPeopleGreaterThanName(@RequestParam String name) {
        return servicePersonRepository.getGreaterPeopleByName(name);
    }

    @GetMapping("/lessThan/name")
    public List<PersonOutputFatherDto> getPeopleLessThanName(@RequestParam String name) {
        return servicePersonRepository.getLessPeopleByName(name);
    }

    @GetMapping("/greaterThan/surname")
    public List<PersonOutputFatherDto> getPeopleGreaterThanSurname(@RequestParam String surname) {
        return servicePersonRepository.getGreaterPeopleBySurname(surname);
    }

    @GetMapping("/lessThan/surname")
    public List<PersonOutputFatherDto> getPeopleLessThanSurname(@RequestParam String surname) {
        return servicePersonRepository.getLessPeopleBySurname(surname);
    }

    @GetMapping("/greaterThan/dateCreated")
    public List<PersonOutputFatherDto> getPeopleGreaterThanDateCreated(@RequestParam Date dateCreate) {
        return servicePersonRepository.getGreaterPeopleByDateCreate(dateCreate);
    }

    @GetMapping("/lessThan/dateCreated")
    public List<PersonOutputFatherDto> getPeopleLessThandateCreated(@RequestParam Date dateCreated) {
        return servicePersonRepository.getLessPeopleByDateCreate(dateCreated);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable String id) {
        servicePersonRepository.deletePersonById(id);
    }

    @PutMapping("/{id}")
    public PersonOutputDto updatePerson(@RequestBody PersonInputDto personDtoInput, @PathVariable String id) {
        return servicePersonRepository.modifyPerson(personDtoInput, id);
    }

}
