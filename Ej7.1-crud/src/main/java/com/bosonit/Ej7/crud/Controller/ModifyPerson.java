package com.bosonit.Ej7.crud.Controller;

import com.bosonit.Ej7.crud.Model.Person;
import com.bosonit.Ej7.crud.Services.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/URL")

public class ModifyPerson {
    @Autowired
    private ManagerRepository managerRepository;

    @PutMapping(value ="persona/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person modifyPerson(@PathVariable String id, @RequestBody Person person){
        return managerRepository.modifiedPersonById(id, person);
    }
}
