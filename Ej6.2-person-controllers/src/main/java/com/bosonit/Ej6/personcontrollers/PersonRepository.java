package com.bosonit.Ej6.personcontrollers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class PersonRepository {

    private static List<Person> people= new ArrayList();


    public Person createPerson(String nombre, String ciudad, Integer edad){
        return new Person(nombre, ciudad, edad);
    }

    @Bean
    public Person bean1(){
        return this.createPerson("Amanda", "Tegucigalpa", 25);
    }

    @Bean
    public Person bean2(){
        return this.createPerson("Ricardito", "Teheran", 35);
    }

    @Bean
    public Person bean3(){
        return this.createPerson("Sofia", "Wakanda", 48);
    }


    public void add(Person person){
        people.add(person);
    }

    public Person getLastPerson(){
        Person person = people.get(people.size()-1);
        person= person.multiplyAge(person);

        return person;
    }
}
