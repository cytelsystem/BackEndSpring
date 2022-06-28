package com.dh.veterinaria.persistence.entity;

import javax.persistence.*;


@Entity
@Table(name="Mascota")
public class Mascota {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mascotaSequense")
    @SequenceGenerator(name = "mascotaSequense", sequenceName = "mascotaSequense", allocationSize = 1)
    @Column(name = "Id_Mascota", nullable = false)

    private Long id;
    private String nombre;
    private String tipo;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "veterinariaID")
    private Veterinaria veterinaria;




    //*********************************Constructores*************************************//




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

    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }


    //*******************************************************************************************//
}
