package com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output;

import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.input.StudentInput;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentOutputFullDto extends StudentOutputDto  {

    private String id;

    private PersonOutputDto person;

    private Integer numHoursWeek;

    private String coments;

    private String branch;

    public StudentOutputFullDto(StudentInput studentDtoInput, Person person){

        setPerson(new PersonOutputDto(person));
        setComents(studentDtoInput.getComents());
        setNumHoursWeek(studentDtoInput.getNumHoursWeek());
        setBranch(studentDtoInput.getBranch());
    }

    public StudentOutputFullDto(Student student){

        setId(student.getId());
        setPerson(new PersonOutputDto(student.getPerson()));
        setNumHoursWeek(student.getNumHoursWeek());
        setComents(student.getComents());
        setBranch(student.getBranch());
    }

}
