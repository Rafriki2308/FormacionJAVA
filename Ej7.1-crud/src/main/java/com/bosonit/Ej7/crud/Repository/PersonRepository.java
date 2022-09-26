package com.bosonit.Ej7.crud.Repository;

import com.bosonit.Ej7.crud.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PersonRepository {

    public static List<Person> personList = new ArrayList<>();

    private Person person1 = this.add(createPerson("Amarosa", 60, "Polopos"));
    private Person person2 = this.add(createPerson("Benicio", 52, "Sebastopol"));
    private Person person3 = this.add(createPerson("Dionisia", 25, "Westview"));
    private Person person4 = this.add(createPerson("Benedicto", 30, "River City"));


    public Person createPerson(String name, int age, String city){
        return new Person(name, age, city );
    }

    public Person add(Person person){
        person.setId( personList.size()+1);
        personList.add(person);
        return person;
    }

    public Person getPersonById(int id){
        return personList.get(id-1);
    }

    public Person getPersonByName(String name) throws NoSuchObjectException {

        for (Person p : personList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        throw new NoSuchObjectException("No se ha encontrado dicha persona");
    }

    public boolean testPerson(Person person){
        return !(person.getName().isEmpty() || person.getAge()==0 || person.getCity().isEmpty());
    }

    public Person modifyPersonById(long id, Person personModified){

        if(testPerson(personModified)){
            personModified.setId(id);
            personList.set((int)id - 1, personModified);
        }

        return personList.get((int)id-1);
    }

    public Boolean deletePersonById(long id){
        return personList.remove(personList.get((int)id - 1));
    }

}
