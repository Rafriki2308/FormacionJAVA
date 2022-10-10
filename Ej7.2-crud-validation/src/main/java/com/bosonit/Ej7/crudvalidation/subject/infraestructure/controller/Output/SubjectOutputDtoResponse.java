package com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output;

import org.springframework.stereotype.Component;
import com.bosonit.Ej7.crudvalidation.model.Subject;


import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectOutputDtoResponse {

    public static List<SubjectOutputDto>mappingSubjectToSubjectOutputDto(List<Subject> listSubject){

        List<SubjectOutputDto> listSubjectOutputDto = new ArrayList<>();
        for (Subject s: listSubject) {
            listSubjectOutputDto.add(new SubjectOutputDto(s));
        }
        return listSubjectOutputDto;
    }

}
