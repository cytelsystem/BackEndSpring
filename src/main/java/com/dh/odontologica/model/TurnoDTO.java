package com.dh.odontologica.model;


import com.dh.odontologica.persistence.entity.Odontologo;
import com.dh.odontologica.persistence.entity.Paciente;

import java.sql.Date;


public class TurnoDTO {

    private Long id;
    private Date date;
    private Odontologo odontologo;
    private Paciente paciente;


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


    //**************************************************************************************************//

}
