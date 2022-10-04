package com.bosonit.Ej7.crudvalidation.student.domain;

import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.input.StudentInput;
import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

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

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Professor professor;*/

    @Column(name="rama")
    private String branch;

   /* @OneToMany
    List<Subject> studies;*/

    public Student(StudentInput studentDtoInput, Person person){

        setPerson(person);
        setNumHoursWeek(studentDtoInput.getNumHoursWeek());
        setComents(studentDtoInput.getComents());
        setBranch(studentDtoInput.getBranch());
    }

}
