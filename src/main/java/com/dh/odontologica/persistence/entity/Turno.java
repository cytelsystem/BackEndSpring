package com.dh.odontologica.persistence.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turnoSequence")
    @SequenceGenerator(name = "turnoSequence", sequenceName = "turnoSequence", allocationSize = 1)

    @Column(name = "id_turno", nullable = false)
    private Long id;

    private Date date;
    private Paciente paciente;
    private Odontologo odontologo;


    //***********************************Constructores***************************************//

    public Turno() {
    }

    public Turno(Date date, Paciente paciente, Odontologo odontologo) {
        this.date = date;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    //*********************************Getter y setter****************************************//

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }


//**********************************toString y hashCode***********************************//




    //***************************************Metodos***************************************//





}
