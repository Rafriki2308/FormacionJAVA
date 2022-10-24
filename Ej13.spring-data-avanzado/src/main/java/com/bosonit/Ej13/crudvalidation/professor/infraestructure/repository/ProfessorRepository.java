package com.bosonit.Ej13.crudvalidation.professor.infraestructure.repository;

import com.bosonit.Ej13.crudvalidation.professor.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {

    Professor findProfessorById(String id);

    Professor save(Professor professor);
}
