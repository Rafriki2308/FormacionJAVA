package com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Input;

import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class SubjectInputDto implements Serializable {

    private String id;

    private String nameSubject;

    private String comment;

    private Date initialDate;

    private Date finishDate;

}
