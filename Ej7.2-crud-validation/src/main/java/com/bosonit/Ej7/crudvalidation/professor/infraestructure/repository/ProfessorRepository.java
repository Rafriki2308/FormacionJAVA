package com.bosonit.Ej7.crudvalidation.professor.infraestructure.repository;

import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {

    Professor findProfessorById(String id);
}
