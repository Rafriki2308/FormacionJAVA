package com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output;

import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentResponseDto {

    public List<StudentOutputFullDto> mappingStudentToStudentDtoOutput(List<Student> listStudent){

        List<StudentOutputFullDto> listStudentDtoOutput = new ArrayList<>();
        for (Student s: listStudent) {
            listStudentDtoOutput.add(new StudentOutputFullDto(s));
        }
        return listStudentDtoOutput;
    }


}
