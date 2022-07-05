package com.dh.odontologica.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


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
    private LocalDate fechaDeIngreso;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();



    //**************************************Constructores********************************************//

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String email, String dni, LocalDate fechaDeIngreso, Domicilio domicilio, Set<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
        this.turnos = turnos;
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

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }


    //****************************************************************************************//

}
