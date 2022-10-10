package com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output;

import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentResponseDto {

    public static List<StudentOutputFullDto> mappingStudentToStudentDtoOutput(List<Student> listStudent){

        List<StudentOutputFullDto> listStudentDtoOutput = new ArrayList<>();
        for (Student s: listStudent) {
            listStudentDtoOutput.add(new StudentOutputFullDto(s));
        }
        return listStudentDtoOutput;
    }

    public static List<StudentOutputSimpleDto> mappingStudentToStudentDtoOutputSimple(List<Student> listStudent){

        List<StudentOutputSimpleDto> listStudentDtoOutput = new ArrayList<>();
        for (Student s: listStudent) {
            listStudentDtoOutput.add(new StudentOutputSimpleDto(s));
        }
        return listStudentDtoOutput;
    }


}
