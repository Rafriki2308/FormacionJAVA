package com.bosonit.Ej6.personcontrollers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


public class Person {

    private String nombre;

    private String ciudad;

    private Integer edad;


    public Person(String nombre, String ciudad, Integer edad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Person multiplyAge(Person person){
        this.edad = person.getEdad() * 2;
        return person;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", edad=" + edad +
                '}';
    }
}
