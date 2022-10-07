package com.bosonit.Ej7.crudvalidation.model;

import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import com.bosonit.Ej7.crudvalidation.subject.infraestructure.controller.Input.SubjectInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="asignatura")

public class Subject {

    @Id
    @GeneratedValue(generator = "subjectGenerator")
    @GenericGenerator(name = "subjectGenerator",
            strategy = "com.bosonit.Ej7.crudvalidation.idGenerator.MyGenerator")
    @Column(name = "id_asignatura")
    private String id;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Professor professor;*/

    @ManyToMany(mappedBy = "subjects")
    List<Student> students =new ArrayList<>();

    @Column(name = "asignatura")
    private String nameSubject;

    @Column(name = "comentarios")
    private String comment;

    @Column(name = "initial_date")
    private Date initialDate;

    @Column(name = "finish_date")
    private Date finishDate;

    public Subject(SubjectInputDto subjectInputDto){

        setNameSubject(subjectInputDto.getNameSubject());
        setComment(subjectInputDto.getComment());
        setInitialDate(subjectInputDto.getInitialDate());
        setFinishDate(subjectInputDto.getFinishDate());
    }

    public Subject(SubjectInputDto subjectInputDto, String subjectId){
        setId(subjectId);
        setNameSubject(subjectInputDto.getNameSubject());
        setComment(subjectInputDto.getComment());
        setInitialDate(subjectInputDto.getInitialDate());
        setFinishDate(subjectInputDto.getFinishDate());
    }

    public List<Student> addStudentToStudentsList(Student student){
        students.add(student);
        return students;
    }
}
