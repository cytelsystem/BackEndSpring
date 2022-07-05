package com.dh.odontologica.model;


import com.dh.odontologica.persistence.entity.Domicilio;


import java.time.LocalDate;
import java.util.Date;

public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private LocalDate fechaDeIngreso;
    private Domicilio domicilio;


    //**********************************Constructor*****************************************//

    //**********************************Getter y Setter**********************************//

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

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }


    //*****************************************************************************************//


}
