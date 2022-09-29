package com.bosonit.Ej7.crudvalidation.model;

import com.bosonit.Ej7.crudvalidation.personDto.PersonDtoInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name="persona")
public class Person implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_persona")
    private Integer id;

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


    public Person(PersonDtoInput persona) {

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
