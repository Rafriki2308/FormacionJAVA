package com.bosonit.Ej7.crudvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="profesor")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_profesor")
    private Integer id;

    @Column(name="id_persona")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Person person;

    @Column(name = "Comentarios")
    private String coments;

    @Column(name="rama")
    private String branch;

    @OneToMany
    List<Student> students;
}
