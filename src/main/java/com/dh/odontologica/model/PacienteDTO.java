package com.dh.odontologica.model;


import java.util.Date;

public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Date fechaDeIngreso;
    private DomicilioDTO domicilio;


    //**************************************Constructores********************************************//


    public PacienteDTO() {

    }

    public PacienteDTO(Long id, String nombre, String apellido, String email, String dni, Date fechaDeIngreso, DomicilioDTO domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
    }

    //**************************************Getter y Setter****************************************//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public DomicilioDTO getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioDTO domicilio) {
        this.domicilio = domicilio;
    }

    //*****************************************toString*****************************************//

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaDeIngreso=" + fechaDeIngreso +
                ", domicilio=" + domicilio +
                '}';
    }


    //*************************************Metodos****************************************//


}
