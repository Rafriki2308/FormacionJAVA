package com.bosonit.Ej7.crudvalidation.Repository;

import com.bosonit.Ej7.crudvalidation.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
