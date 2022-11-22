package com.bosonit.Ej15Security.person.infraestructure.repository;

import com.bosonit.Ej15Security.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

public interface PersonRepository extends JpaRepository<Person, Objects> {
    Person findPersonaById(Integer id);

    List<Person> findByName(String name);

    Person findByUser(String username);

}
