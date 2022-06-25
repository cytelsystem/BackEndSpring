package com.dh.escuela.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="Materia")
public class Materia {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_materia", nullable = false)

    private Long id;
    private String nombre;



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


