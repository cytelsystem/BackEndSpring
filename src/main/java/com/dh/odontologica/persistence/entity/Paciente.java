package com.dh.odontologica.persistence.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacienteSequence")
    @SequenceGenerator(name = "pacienteSequence", sequenceName = "pacienteSequence", allocationSize = 1)

    @Column(name = "id_paciente", nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Date fechaDeIngreso;



    //**************************************Constructores********************************************//

    public Paciente() {
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



    //*************************************Metodos****************************************//


}
