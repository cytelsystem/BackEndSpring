package com.dh.futbol.persistence.entity;

import javax.persistence.*;


@Entity
@Table
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "jugador_id", nullable = false)
    private int id;

    @Column
    private String nombre;
    @Column
    private String puesto;
    @Column
    private int numero;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;



    //*********************************Constructores*************************************//


    public Jugador() {
    }

    public Jugador(String nombre, String puesto, int numero) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.numero = numero;
    }

    //**********************************Getter y setter*****************************************//
    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //*******************************************************************************************//
}
