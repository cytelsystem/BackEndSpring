package com.dh.escuela.persistence.entity;


import com.dh.escuela.persistence.entity.Estudiante;
import com.dh.escuela.persistence.entity.Materia;

import javax.persistence.*;

@Entity
@Table(name = "cursada")
public class Cursada {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name="materia_id", nullable = false)
    private Materia materia;

    private double nota;


    //**********************************Constructores****************************************//
    //**********************************Getter y Setter****************************************//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }


    //**********************************Metodos*****************************************//
    //*********************************************************************************************//
    //*********************************************************************************************//



}
