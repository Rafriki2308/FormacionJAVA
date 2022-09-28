package com.bosonit.Ej7.crudvalidation.repository;

import com.bosonit.Ej7.crudvalidation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findPersonaById(Integer id);

    Person findByUser(String name);

}
