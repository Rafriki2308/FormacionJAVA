package com.bosonit.Ej13.crudvalidation.professor.infraestructure.controller.Output;

import com.bosonit.Ej13.crudvalidation.professor.domain.Professor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorOutputResponseDto {

    public List<ProfessorOutputFullDto> mappingProfessorToProfessorOutput(List<Professor> listProfessors){

        List<ProfessorOutputFullDto> listProfessorOutputList = new ArrayList<>();
        for (Professor p: listProfessors) {
            listProfessorOutputList.add(new ProfessorOutputFullDto(p));
        }
        return listProfessorOutputList;
    }

}
