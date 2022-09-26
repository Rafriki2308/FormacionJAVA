package com.bosonit.Ej7.crud.Controller;

import com.bosonit.Ej7.crud.Model.Person;
import com.bosonit.Ej7.crud.Services.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/URL")
public class AddPersonController {

    @Autowired
    private ManagerRepository managerRepository;

    @PostMapping(value = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person addPerson(@RequestBody Person person){
        return managerRepository.addPerson(person);
    }
}
