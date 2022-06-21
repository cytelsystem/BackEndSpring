package com.dh.escuela.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
public class Escuela {
    @Id
    @SequenceGenerator(name = "escuela_sequence", sequenceName = "escuela_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "escuela_sequence")

    private Long id;
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "escuela", fetch = FetchType.LAZY) // no carga los alumnos hasta que no se nececiten

    private Set<Alumno> alumnos = new HashSet<>(); // instanciar alumnos y crear getter y setter

    //*********************************Constructores*************************************//


    public Escuela() { // Constructor obligado por default

    }

    public Escuela(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }


    //**********************************Getter y setter*****************************************//

    public Long getId() {
        return id;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    //*********************************************************************************************//


}
