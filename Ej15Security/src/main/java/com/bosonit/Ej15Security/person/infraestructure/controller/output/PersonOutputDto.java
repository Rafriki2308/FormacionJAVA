package com.bosonit.Ej15Security.person.infraestructure.controller.output;


import com.bosonit.Ej15Security.person.domain.Person;
import com.bosonit.Ej15Security.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.Ej15Security.role.domain.Role;
import com.bosonit.Ej15Security.role.infrastructure.controller.Output.RoleResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {

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

    private Collection<Role> roles = new ArrayList<>();

    @Autowired
    @JsonIgnore
    @ToString.Exclude
    private RoleResponseDto roleResponseDto;

    public PersonOutputDto(PersonInputDto persona) {

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


    public PersonOutputDto(Person persona){
        setId(persona.getId());
        setUser(persona.getUsername());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());
        setRoles(persona.getRoles());
    }
}
