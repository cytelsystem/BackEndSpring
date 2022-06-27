package com.dh.odontologica.model;

import java.sql.Date;
import java.util.Objects;

public class TurnoDTO {

    private Long id;
    private Date date;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;

    //***********************************Constructores***************************************//

    public TurnoDTO() {

    }

    public TurnoDTO(Long id, Date date, PacienteDTO paciente, OdontologoDTO odontologo) {
        this.id = id;
        this.date = date;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }
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

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TurnoDTO)) return false;
        TurnoDTO turno = (TurnoDTO) o;
        return Objects.equals(id, turno.id) && Objects.equals(paciente, turno.paciente) && Objects.equals(odontologo, turno.odontologo) && Objects.equals(date, turno.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paciente, odontologo, date);
    }


    //***************************************Metodos***************************************//





}
