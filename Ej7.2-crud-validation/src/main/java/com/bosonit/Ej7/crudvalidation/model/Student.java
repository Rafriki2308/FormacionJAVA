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
@Table(name="estudiante")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estudiante")
    private Integer id;

    @Column(name="id_persona")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Person person;

    @Column(name="horas_por_semana")
    private Integer numHoursWeek;

    @Column(name = "Comentarios")
    private String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Professor professor;

    @Column(name="rama")
    private String branch;

    @OneToMany
    List<Subject> studies;

}
