package com.bosonit.ej3.mongodb.person.infraestructure.repository;


import com.bosonit.ej3.mongodb.person.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
    Person findPersonaById(String id);

    List<Person> findByUser(String name);

}
