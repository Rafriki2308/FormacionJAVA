package com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.input;

import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import lombok.Data;

import java.io.Serializable;
@Data
public class StudentInput implements Serializable {


    private Person person;

    private Integer numHoursWeek;

    private String coments;

    private String branch;


}
