package com.dh.futbol.persistence.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "equipo_id", nullable = false)
    private int id;

    @Column
    private String nombre;
    @Column
    private String ciudad;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY) // no carga los alumnos hasta que no se nececiten

    private Set<Jugador> jugadores = new HashSet<>(); // instanciar alumnos y crear getter y setter

    //**************************************Constructores*******************************************//


    public Equipo() {
    }

    public Equipo(String nombre, String ciudad, Set<Jugador> jugadores) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.jugadores = jugadores;
    }

    //**************************************Getter y setter*******************************************//
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    //**********************************************************************************************//

}
