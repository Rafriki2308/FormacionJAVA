package com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output;

import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputFullDto;
import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output.SubjectOutputDto;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output.SubjectOutputDtoResponse;
import com.bosonit.Ej7.crudvalidation.model.Subject;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentOutputFullDto extends StudentOutputDto  {

    private String id;

    private PersonOutputDto person;

    private Integer numHoursWeek;

    private String coments;

    private String branch;

    private ProfessorOutputFullDto professor;

    private List<SubjectOutputDto> subjects = new ArrayList<>();


    public StudentOutputFullDto(Student student){

        setId(student.getId());
        setPerson(new PersonOutputDto(student.getPerson()));
        setNumHoursWeek(student.getNumHoursWeek());
        setComents(student.getComents());
        setBranch(student.getBranch());
        setProfessor(new ProfessorOutputFullDto(student.getProfessor()));
        //Transforma una lista de Subject en tipo subjectDto.
        setSubjects(SubjectOutputDtoResponse.mappingSubjectToSubjectOutputDto(student.getSubjects()));

    }

}
