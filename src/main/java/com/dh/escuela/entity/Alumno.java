package com.dh.escuela.entity;


import javax.persistence.*;

@Entity
@Table
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_Sequence")
    @SequenceGenerator(name = "alumno_Sequence", sequenceName = "alumno_Sequence")

    private Long id;
    private String nombre;
    private int edad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "escuela_id")
    private Escuela escuela;

    //**********************************Constructores*************************************//


    public Alumno() {

    }

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //***********************************Getter y Setter********************************************//
    public Long getId() {
        return id;
    }
    //*************************************************************************************************//
    //*************************************************************************************************//



}
