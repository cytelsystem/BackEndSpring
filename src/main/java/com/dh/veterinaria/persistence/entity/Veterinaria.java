package com.dh.veterinaria.persistence.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Equipo")
public class Veterinaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_veterinaria", nullable = false)

    private Long id;
    @Column
    private String nombre;
    @Column
    private int costo;



    //**************************************Constructores*******************************************//

    public Veterinaria() {
    }

    public Veterinaria(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    //**************************************Getter y setter*******************************************//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    //**********************************************************************************************//

}
