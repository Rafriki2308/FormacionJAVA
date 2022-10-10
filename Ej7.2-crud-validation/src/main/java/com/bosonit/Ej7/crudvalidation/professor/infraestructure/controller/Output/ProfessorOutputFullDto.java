package com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output;

import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProfessorOutputFullDto extends ProfessorOutputDto{

    private String id;

    private PersonOutputDto person;

    private String comments;

    private String branch;

    private List<Student> students;

    public ProfessorOutputFullDto(Professor professor){

        setId(professor.getId());
        setPerson(new PersonOutputDto(professor.getPerson()));
        setComments(professor.getComments());
        setBranch(professor.getBranch());
    }

}
