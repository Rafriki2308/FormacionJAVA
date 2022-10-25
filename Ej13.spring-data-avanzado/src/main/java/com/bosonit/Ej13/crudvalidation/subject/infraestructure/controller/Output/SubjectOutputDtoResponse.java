package com.bosonit.Ej13.crudvalidation.subject.infraestructure.controller.Output;

import com.bosonit.Ej13.crudvalidation.subject.domain.Subject;
import org.springframework.stereotype.Component;


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
