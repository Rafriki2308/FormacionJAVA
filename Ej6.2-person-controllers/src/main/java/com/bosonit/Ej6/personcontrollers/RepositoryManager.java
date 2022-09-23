package com.bosonit.Ej6.personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryManager {

    @Autowired
    PersonRepository repoPerson;
    @Autowired
    CityRepository repoCity;

    public Person createPerson(String nombre, String ciudad, String edad){
        return repoPerson.createPerson(nombre, ciudad, Integer.parseInt(edad));
    }

    public void addPerson(Person person){
        repoPerson.add(person);
    }

    public Person modifyLastPerson(){

        return repoPerson.getLastPerson();
    }

    public City createCity(String nombre, String numeroHabitantes){
        return repoCity.create(nombre, Integer.parseInt(numeroHabitantes));
    }

    public void addCity(City city){
        repoCity.add(city);
    }

    public List getAllCities(){
        return repoCity.getLastCity();

    }

}
