package com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.output;

import com.bosonit.Ej13.crudvalidation.student.domain.Student;
import lombok.Data;

@Data
public class StudentOutputSimpleDto extends StudentOutputDto {

    private String id;

    private Integer numHoursWeek;

    private String coments;


    public StudentOutputSimpleDto(Student student){

        setId(student.getId());
        setNumHoursWeek(student.getNumHoursWeek());
        setComents(student.getComents());
    }
}
