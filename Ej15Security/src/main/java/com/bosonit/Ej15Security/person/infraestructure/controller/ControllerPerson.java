package com.bosonit.Ej15Security.person.infraestructure.controller;


import com.bosonit.Ej15Security.person.application.PersonServiceImpl;
import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej15Security.role.application.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControllerPerson {

    @Autowired
    private PersonServiceImpl servicePersonRepository;
    @Autowired
    RoleServiceImp roleServiceImp;

    @PostMapping("")
    public Object addPerson(@RequestBody PersonInputDto personDtoInput) {
        try {
            return servicePersonRepository.addPerson(personDtoInput);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Username already existed");
        }
    }

    @PostMapping(value = "/addRoleToUser")
    public PersonOutputDto addRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        return roleServiceImp.addRoleToPerson(username, roleName);
    }

    @GetMapping("/getPersonById/{id}")
    public PersonOutputDto getPersonById(@PathVariable String id) {

        return servicePersonRepository.getPersonById(Integer.parseInt(id));
    }

    @GetMapping("/getPersonByName/{name}")
    public List<PersonOutputDto> getPersonByName(@PathVariable String name) {

        return servicePersonRepository.getPersonByName(name);
    }

    @GetMapping("/all")
    public List<PersonOutputDto> getAllPeople() {
        return servicePersonRepository.getAllPeople();
    }

    @DeleteMapping("/{id}")
    public Object deletePersonById(@PathVariable String id) {

        servicePersonRepository.deletePersonById(Integer.parseInt(id));
        return ResponseEntity.ok().body("Person Deleted");
    }


    @PutMapping("/{id}")
    public PersonOutputDto updatePerson(@RequestBody PersonInputDto personDtoInput, @PathVariable String id) {
        return servicePersonRepository.modifyPerson(personDtoInput, Integer.parseInt(id));
    }

}
