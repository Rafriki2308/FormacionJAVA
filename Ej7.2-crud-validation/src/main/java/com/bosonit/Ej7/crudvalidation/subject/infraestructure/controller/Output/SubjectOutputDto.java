package com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Output;

import java.io.Serializable;
import java.util.Date;
import com.bosonit.Ej7.crudvalidation.model.Subject;
import lombok.Data;

@Data
public class SubjectOutputDto implements Serializable {


    private String id;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Professor professor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estudiante")
    Student student;*/

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

    }
}
