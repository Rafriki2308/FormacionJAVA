package com.bosonit.Ej13.crudvalidation.person.infraestructure.repository;

import com.bosonit.Ej13.crudvalidation.person.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String>{
    Person findPersonaById(String id);

    List<Person> findByUser(String name);

    Page findAll(Pageable pageable);

}
