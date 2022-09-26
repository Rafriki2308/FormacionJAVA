package com.bosonit.Ej7.crud.Model;

import java.util.concurrent.atomic.AtomicLong;

public class Person {

    private long id = 0;
    private String name;

    private int age;

    private String city;

    private static final AtomicLong counter = new AtomicLong();

    public Person(String name, int age, String city) {

        this.name = name;
        this.age = age;
        this.city = city;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
