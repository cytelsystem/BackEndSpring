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
//    private Paciente paciente;
//    private Odontologo odontologo;


    //***********************************Constructores***************************************//



    //*********************************Getter y setter****************************************//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


//**********************************toString y hashCode***********************************//




    //***************************************Metodos***************************************//





}
