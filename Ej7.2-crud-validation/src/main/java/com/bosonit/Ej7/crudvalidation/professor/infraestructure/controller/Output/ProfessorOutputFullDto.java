package com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output;

import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.input.ProfessorInputDto;
import lombok.Data;

@Data

public class ProfessorOutputFullDto extends ProfessorOutputDto{

    private String id;

    private PersonOutputDto person;

    private String comments;

    private String branch;

    public ProfessorOutputFullDto(Professor professor){

        setId(professor.getId());
        setPerson(new PersonOutputDto(professor.getPerson()));
        setComments(professor.getComments());
        setBranch(professor.getBranch());
    }

    public ProfessorOutputFullDto(ProfessorInputDto professorInputDto, Person person){

        setPerson(new PersonOutputDto(person));
        setComments(professorInputDto.getComments());
        setBranch(professorInputDto.getBranch());

    }
}
