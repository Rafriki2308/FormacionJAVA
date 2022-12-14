package com.bosonit.Ej15Security.person.infraestructure.repository;

import com.bosonit.Ej15Security.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface PersonRepository extends JpaRepository<Person, Objects> {
    Person findPersonaByIdPerson(Integer idPerson);

    List<Person> findByName(String name);

    Person findByUsername(String username);

}
