package com.dh.odontologica.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odontologo")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologoSequence")
    @SequenceGenerator(name = "odontologoSequence", sequenceName = "odontologoSequence", allocationSize = 1)

    @Column(name = "id_odontologo", nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String matricula;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();


//    @OneToOne(mappedBy = "odontologo")
//    @JsonIgnore
//    private Turno turno;



    //*****************************Constructores***********************************//

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    //************************Getter y setter***************************//

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }


    //******************************************************************//

}
