package com.bosonit.Ej7.crudvalidation.professor.domain;

import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.input.ProfessorInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="profesor")
public class Professor {

    @Id
    @GeneratedValue(generator = "professorGenerator")
    @GenericGenerator(name = "professorGenerator",
            strategy = "com.bosonit.Ej7.crudvalidation.idGenerator.MyGenerator")
    @Column(name = "id_profesor")
    private String id;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Person person;

    @Column(name = "comentarios")
    private String comments;

    @Column(name="rama")
    private String branch;
    /*
    @OneToMany
    List<Student> students;*/

    public Professor(ProfessorInputDto professorInputDto, Person person){
        setPerson(person);
        setComments(professorInputDto.getComments());
        setBranch(professorInputDto.getBranch());
    }

}
