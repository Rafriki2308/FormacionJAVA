package com.bosonit.Ej6.personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/controlador1")
public class Controlador1 {

    @Autowired
    RepositoryManager repositoryManager;

    @GetMapping(value = "/addPersona")
    public Person addPersona(@RequestParam String nombre, @RequestParam String edad, @RequestParam String ciudad){

        Person person = repositoryManager.createPerson(nombre,ciudad,edad);
        repositoryManager.addPerson(person);
        return person;
    }

    @PostMapping (value = "/addCiudad")
    public void addCity(@RequestParam String nombre, @RequestParam String numeroHabitantes){

        City city = repositoryManager.createCity(nombre,numeroHabitantes);
        repositoryManager.addCity(city);
    }

}
