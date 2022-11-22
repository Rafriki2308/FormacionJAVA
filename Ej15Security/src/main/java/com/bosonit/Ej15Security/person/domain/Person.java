package com.bosonit.Ej15Security.person.domain;

import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.role.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name="persona")
public class Person{

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

    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();


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

    public Person(PersonInputDto persona, Integer idPersona) {

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

    public Collection<Role> getRoles(){
        return this.roles;
    }


}
