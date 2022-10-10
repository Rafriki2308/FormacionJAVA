package com.bosonit.Ej7.crudvalidation.subject.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bosonit.Ej7.crudvalidation.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,String> {
   Subject findSubjectById(String id);
}
