package com.bosonit.Ej7.crudvalidation.personDto;

import com.bosonit.Ej7.crudvalidation.model.Person;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonDtoOutput implements Serializable {

    private Integer id;

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

    public PersonDtoOutput(PersonDtoInput persona) {
        setId(persona.getId());
        setUser(persona.getUser());
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


    public PersonDtoOutput(Person persona){
        setId(persona.getId());
        setUser(persona.getUser());
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
