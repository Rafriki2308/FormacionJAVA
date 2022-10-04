package com.bosonit.Ej7.crudvalidation.student.infraestructure.repository;

import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

    Student findStudentById(String id);
}
