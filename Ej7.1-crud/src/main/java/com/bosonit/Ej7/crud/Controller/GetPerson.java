package com.bosonit.Ej7.crud.Controller;

import com.bosonit.Ej7.crud.Model.Person;
import com.bosonit.Ej7.crud.Services.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/URL")
public class GetPerson {

    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("/persona/{id}")
    public Person getPersonById(@PathVariable String id){
        return managerRepository.getPersonById(id);
    }

    @GetMapping("/persona/nombre/{name}")
    public Person getPersonByName(@PathVariable String name){
        return managerRepository.getPersonByName(name);
    }



}
