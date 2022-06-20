package com.dh.odontologica.model;



import java.sql.Date;
import java.util.Objects;

public class Turno {

    private Long id;
    private Date date;

    private Paciente paciente;
    private Odontologo odontologo;

    //***********************************Constructores***************************************//


    public Turno() {

    }

    public Turno(Long id, Date date, Paciente paciente, Odontologo odontologo) {
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
        if (!(o instanceof Turno)) return false;
        Turno turno = (Turno) o;
        return Objects.equals(id, turno.id) && Objects.equals(paciente, turno.paciente) && Objects.equals(odontologo, turno.odontologo) && Objects.equals(date, turno.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paciente, odontologo, date);
    }


    //***************************************Metodos***************************************//





}
