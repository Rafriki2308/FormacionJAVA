package com.bosonit.Ej13.crudvalidation.professor.infraestructure.controller.input;

import com.bosonit.Ej13.crudvalidation.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProfessorInputDto implements Serializable{

        private Person person;

        private String comments;

        private String branch;

        private String idStudent;
}
