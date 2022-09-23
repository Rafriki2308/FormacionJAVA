package com.bosonit.Ej6.personcontrollers;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CityRepository {

    private static List<City> cities= new ArrayList();

    public City create(String nombre, Integer numeroHabitantes){
        return new City(nombre, numeroHabitantes);
    }

    public void add(City city){
        cities.add(city);
    }

    public List getLastCity(){

        return cities;
    }


}
