package com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output;

import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.input.ProfessorInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorOutputSimpleDto extends ProfessorOutputDto {
    private String id;

    private String comments;

    private String branch;

    public ProfessorOutputSimpleDto(Professor professor){

        setId(professor.getId());
        setComments(professor.getComments());
        setBranch(professor.getBranch());
    }

    public ProfessorOutputSimpleDto (ProfessorInputDto professorInputDto){

        setComments(professorInputDto.getComments());
        setBranch(professorInputDto.getBranch());

    }
}
