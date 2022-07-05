package com.dh.odontologica.persistence.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "Turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turnoSequence")
    @SequenceGenerator(name = "turnoSequence", sequenceName = "turnoSequence", allocationSize = 1)

    @Column(name = "id_turno", nullable = false)
    private Long id;

    private LocalDate date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_odontologo" , referencedColumnName = "id_odontologo")
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_paciente" , referencedColumnName = "id_paciente")
    private Paciente paciente;





    //***********************************Constructores***************************************//
    public Turno() {

    }

    public Turno(LocalDate date, Odontologo odontologo, Paciente paciente) {
        this.date = date;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    //*********************************Getter y setter****************************************//

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    //***************************************************************************************//


}




