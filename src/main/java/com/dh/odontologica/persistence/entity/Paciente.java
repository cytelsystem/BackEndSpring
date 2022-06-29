package com.dh.odontologica.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio" , referencedColumnName = "id_domicilio")
    private Domicilio domicilio;

    @OneToOne(mappedBy = "paciente")
    @JsonIgnore
    private Turno turno;



    //**************************************Constructores********************************************//
    public Paciente() {

    }

    public Paciente(String nombre, String apellido, String email, String dni, Date fechaDeIngreso, Domicilio domicilio, Turno turno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
        this.turno = turno;
    }

    //**************************************Getter y Setter****************************************//

    public Long getId() {
        return id;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }


    //*****************************************toString*****************************************//


}
