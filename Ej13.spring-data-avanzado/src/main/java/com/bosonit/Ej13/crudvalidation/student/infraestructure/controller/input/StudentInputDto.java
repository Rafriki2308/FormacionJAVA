package com.bosonit.Ej13.crudvalidation.student.infraestructure.controller.input;

import com.bosonit.Ej13.crudvalidation.subject.infraestructure.controller.Output.SubjectOutputDto;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentInputDto implements Serializable {


    private String  idPerson;

    private Integer numHoursWeek;

    private String coments;

    private String branch;

    private String idProfessor;

    private List <SubjectOutputDto> subjectOutputDtos = new ArrayList<>();


}
