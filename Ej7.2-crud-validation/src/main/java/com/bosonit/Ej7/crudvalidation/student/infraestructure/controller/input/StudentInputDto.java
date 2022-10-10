package com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.input;

import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output.SubjectOutputDto;
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
