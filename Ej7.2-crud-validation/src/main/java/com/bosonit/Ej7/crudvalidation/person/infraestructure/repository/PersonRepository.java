package com.bosonit.Ej7.crudvalidation.person.infraestructure.repository;

import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    Person findPersonaById(String id);

    List<Person> findByUser(String name);

}
