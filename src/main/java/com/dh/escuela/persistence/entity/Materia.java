package com.dh.escuela.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="materia")
public class Materia {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_materia", nullable = false)

    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "materia")
    @JsonIgnore
    private Set<Cursada> cursadas;



    //*****************************************Constructores***************************************//

    public Materia() {
    }

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    //*****************************************Getter y Setter*********************************************//

    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //*****************************************************************************************************//
}


