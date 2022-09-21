package com.bosonit.Ej6.simplecontroller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController

public class SimpleController {

    @GetMapping(value = "/user/{nombre}")
    public String getNombre(@PathVariable String nombre){
        return "Hola " + nombre;
    }

    @PostMapping(value = "/useradd", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person addPerson(@RequestBody Person person){
        return person.upAge(person);
    }
}
