package com.dh.escuela.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_estudiante", nullable = false)

    private Long id;
    private String nombre;
    private String apellido;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
