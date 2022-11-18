package com.bosonit.Ej15SpringSecurity.person.infraestructure.repository;

import com.bosonit.Ej15SpringSecurity.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

public interface PersonRepository extends JpaRepository<Person, Objects> {
    Person findPersonaById(Integer id);

    List<Person> findByUser(String name);

}
