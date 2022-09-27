package com.bosonit.Ej7.crudvalidation.Controllers;

import com.bosonit.Ej7.crudvalidation.PersonDto.PersonDtoInput;
import com.bosonit.Ej7.crudvalidation.PersonDto.PersonDtoOutput;
import com.bosonit.Ej7.crudvalidation.Repository.PersonRepository;
import com.bosonit.Ej7.crudvalidation.Services.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerPersona {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping("/persona")
    public PersonDtoOutput addPerson(@RequestBody PersonDtoInput personDtoInput) throws Exception {
        return serviceRepository.addPerson(personDtoInput);
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
