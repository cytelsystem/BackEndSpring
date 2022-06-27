package com.dh.odontologica.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.Objects;

public class TurnoDTO {

    private Long id;
    private Date date;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;

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

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public OdontologoDTO getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoDTO odontologo) {
        this.odontologo = odontologo;
    }


//**********************************toString y hashCode***********************************//




    //***************************************Metodos***************************************//





}
