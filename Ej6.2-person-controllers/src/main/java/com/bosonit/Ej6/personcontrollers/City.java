package com.bosonit.Ej6.personcontrollers;

public class City {

    private String nombre;
    private Integer numeroHabitantes;

    public City(String nombre, Integer numeroHabitantes) {
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(Integer numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    @Override
    public String toString() {
        return "City{" +
                "nombre='" + nombre + '\'' +
                ", numeroHabitantes=" + numeroHabitantes +
                '}';
    }
}
