package com.bosonit.Ej7.crudvalidation.person.infraestructure.controller.output;

import com.bosonit.Ej7.crudvalidation.person.domain.Person;
import com.bosonit.Ej7.crudvalidation.student.infraestructure.controller.output.StudentOutputSimpleDto;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputStudentDto extends PersonOutputFatherDto{

    private String id;

    private String user;

    private String name;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private Boolean active;

    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    private StudentOutputSimpleDto studentData;

    public PersonOutputStudentDto(Person person){
        setId(person.getId());
        setUser(person.getUser());
        setName(person.getName());
        setSurname(person.getSurname());
        setCompany_email(person.getCompany_email());
        setPersonal_email(person.getPersonal_email());
        setCity(person.getCity());
        setActive(person.getActive());
        setCreated_date(person.getCreated_date());
        setImagen_url(person.getImagen_url());
        setTermination_date(person.getTermination_date());
        setStudentData(new StudentOutputSimpleDto(person.getStudent()));
    }
}
