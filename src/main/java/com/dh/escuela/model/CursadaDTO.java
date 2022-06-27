package com.dh.escuela.model;


import com.dh.escuela.persistence.entity.Estudiante;
import com.dh.escuela.persistence.entity.Materia;

public class CursadaDTO {

    private Long id;
    private double nota;
    private Estudiante estudiante;
    private Materia materia;




    //**********************************Constructores*****************************************//

    //**********************************Getter y setter******************************************//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
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


    //***********************************Metodos*************************************************//
    //***************************************************************************************************//



}
