package com.dh.odontologica.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;


@Document(collection = "Paciente")
public class Paciente {

    @Id
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Date fechaDeIngreso;


    //**************************************Constructores********************************************//
    public Paciente() {

    }

    public Paciente(String nombre, String apellido, String email, String dni, Date fechaDeIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
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


    //*****************************************toString*****************************************//


}
