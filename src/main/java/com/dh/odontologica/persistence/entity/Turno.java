package com.dh.odontologica.persistence.entity;

//import javax.persistence.*;
//import java.sql.Date;
//
//
//@Entity
//@Table(name = "Turno")
//public class Turno {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turnoSequence")
//    @SequenceGenerator(name = "turnoSequence", sequenceName = "turnoSequence", allocationSize = 1)
//
//    @Column(name = "id_turno", nullable = false)
//    private Long id;
//
//    private Date date;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_odontologo" , referencedColumnName = "id_odontologo")
//    private Odontologo odontologo;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_paciente" , referencedColumnName = "id_paciente")
//    private Paciente paciente;
//
//
//
//
//
//    //***********************************Constructores***************************************//
//
//    public Turno() {
//    }
//
//    public Turno(Date date, Odontologo odontologo, Paciente paciente) {
//        this.date = date;
//        this.odontologo = odontologo;
//        this.paciente = paciente;
//    }
//
//    //*********************************Getter y setter****************************************//
//
//    public Long getId() {
//        return id;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Odontologo getOdontologo() {
//        return odontologo;
//    }
//
//    public void setOdontologo(Odontologo odontologo) {
//        this.odontologo = odontologo;
//    }
//
//    public Paciente getPaciente() {
//        return paciente;
//    }
//
//    public void setPaciente(Paciente paciente) {
//        this.paciente = paciente;
//    }
//
//
//    //***************************************************************************************//
//
//
//}



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_odontologo")
    private Odontologo odontologo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;




}



