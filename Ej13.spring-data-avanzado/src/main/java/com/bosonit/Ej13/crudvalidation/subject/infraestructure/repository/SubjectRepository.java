package com.bosonit.Ej13.crudvalidation.subject.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bosonit.Ej13.crudvalidation.subject.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject,String> {
   Subject findSubjectById(String id);
}
