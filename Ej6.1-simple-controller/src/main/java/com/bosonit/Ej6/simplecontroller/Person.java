package com.bosonit.Ej6.simplecontroller;

public class Person {

    private String name;
    private Integer edad;
    private String ciudad;

    public Person() {
    }

    public Person(String name, Integer edad, String ciudad) {
        this.name = name;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Person upAge(Person person){
        person.setEdad(this.edad + 1);
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
