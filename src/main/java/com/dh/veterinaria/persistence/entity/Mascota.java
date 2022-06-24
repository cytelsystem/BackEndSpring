package com.dh.veterinaria.persistence.entity;

import javax.persistence.*;


@Entity
@Table(name="Mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)

    private Long id;
    @Column
    private String nombre;
    @Column
    private String tipo;




    //*********************************Constructores*************************************//


    public Mascota() {
    }

    public Mascota(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    //**********************************Getter y setter*****************************************//

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    //*******************************************************************************************//
}
