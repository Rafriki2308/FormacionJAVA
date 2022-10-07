package com.bosonit.Ej7.crudvalidation.student.domain;

import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.input.StudentInputDto;
import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import com.bosonit.Ej7.crudvalidation.model.Subject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="estudiante")
public class Student implements Serializable {

    @Id
    @GeneratedValue(generator = "studentGenerator")
    @GenericGenerator(name = "studentGenerator",
            strategy = "com.bosonit.Ej7.crudvalidation.idGenerator.MyGenerator")
    @Column(name = "id_estudiante")
    private String id;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Person person;

    @Column(name="horas_por_semana")
    private Integer numHoursWeek;

    @Column(name = "Comentarios")
    private String coments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profesor")
    Professor professor;

    @Column(name="rama")
    private String branch;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "studients_subjects",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    List<Subject> subjects = new ArrayList<>();

    public Student(StudentInputDto studentDtoInput, Person person, Professor professor){

        setPerson(person);
        setNumHoursWeek(studentDtoInput.getNumHoursWeek());
        setComents(studentDtoInput.getComents());
        setBranch(studentDtoInput.getBranch());
        setProfessor(professor);
    }

    public void addSubjectToSubjecList(Subject subject){
        subjects.add(subject);
    }


}
