package com.dh.odontologica.model;

import java.time.LocalDate;

public class Paciente {
    private long id;
    private String apellido;
    private String nombre;
    private String email;
    private String dni;
    private LocalDate fechaDeIngreso;
    private Domicilio domicilio;



    public Paciente(String apellido, String nombre, String email) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.fechaDeIngreso = LocalDate.now();
    }

    public Paciente(String apellido, String nombre, String email, Domicilio domicilio) {
        this(apellido, nombre, email);
        this.domicilio = domicilio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaDeIngreso='" + fechaDeIngreso.toString() + '\'' +
                '}';
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {

        this.domicilio = domicilio;
    }
}
