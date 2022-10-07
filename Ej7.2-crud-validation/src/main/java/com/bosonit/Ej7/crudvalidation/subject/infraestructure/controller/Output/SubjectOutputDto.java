package com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bosonit.Ej7.crudvalidation.model.Subject;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentOutputSimpleDto;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentResponseDto;
import lombok.Data;
import org.hibernate.mapping.Subclass;

@Data
public class SubjectOutputDto implements Serializable {


    private String id;

    private List<StudentOutputSimpleDto> students;

    private String nameSubject;

    private String comment;

    private Date initial_date;

    private Date finish_date;

    public SubjectOutputDto(Subject subject){
        setId(subject.getId());
        setNameSubject(subject.getNameSubject());
        setComment(subject.getComment());
        setInitial_date(subject.getInitialDate());
        setFinish_date(subject.getFinishDate());
        setStudents(StudentResponseDto.mappingStudentToStudentDtoOutputSimple(subject.getStudents()));
    }
}
