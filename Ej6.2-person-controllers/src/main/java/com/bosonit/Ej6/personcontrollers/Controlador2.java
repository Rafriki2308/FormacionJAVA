package com.bosonit.Ej6.personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/controlador2")
public class Controlador2 {

    @Autowired
    RepositoryManager repositoryManager;

    @GetMapping(value = "/getPersona")

    public Person getPersona(){
        return repositoryManager.modifyLastPerson();
    }

    @GetMapping(value="/getCiudades")
    public List getCiudades(){
        return repositoryManager.getAllCities();
    }
}
