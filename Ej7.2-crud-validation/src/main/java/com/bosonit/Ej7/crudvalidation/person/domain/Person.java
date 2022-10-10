package com.bosonit.Ej7.crudvalidation.person.domain;

import com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej7.crudvalidation.professor.domain.Professor;
import com.bosonit.Ej7.crudvalidation.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name="persona")
public class Person implements Serializable{

    @Id
    @GeneratedValue(generator = "personGenerator")
    @GenericGenerator(name = "personGenerator",
            strategy = "com.bosonit.Ej7.crudvalidation.idGenerator.MyGenerator")
    @Column(name = "id_persona")
    private String id;

    @Column (name= "usuario")
    private String user;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String company_email;

    @Column
    private String personal_email;

    @Column
    private String city;

    @Column
    private Boolean active;

    @Column
    private Date created_date;

    @Column
    private String imagen_url;

    @Column
    private Date termination_date;


    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Professor professor;


    public Person(PersonInputDto persona) {

            setUser(persona.getUser());
            setPassword(persona.getPassword());
            setName(persona.getName());
            setSurname(persona.getSurname());
            setCompany_email(persona.getCompany_email());
            setPersonal_email(persona.getPersonal_email());
            setCity(persona.getCity());
            setActive(persona.getActive());
            setCreated_date(persona.getCreated_date());
            setImagen_url(persona.getImagen_url());
            setTermination_date(persona.getTermination_date());
        }

    public Person(PersonInputDto persona, String idPersona) {

        setId(idPersona);
        setUser(persona.getUser());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());
    }


}
