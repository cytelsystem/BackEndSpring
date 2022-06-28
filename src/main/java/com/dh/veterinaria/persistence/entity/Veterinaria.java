package com.dh.veterinaria.persistence.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="veterinaria")
public class Veterinaria {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veterinariaSequence")
    @SequenceGenerator(name = "veterinariaSequence", sequenceName = "veterinariaSequence", allocationSize = 1)
    @Column(name = "Id_Veterinaria", nullable = false)
    private Long id;

    private String nombre;
    private int costo;
    @OneToMany(mappedBy = "veterinaria")
    private List<Mascota> mascota = new ArrayList<>();




    //**************************************Constructores*******************************************//


    //**************************************Getter y setter*******************************************//

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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }


    //**********************************************************************************************//


    @Override
    public String toString() {
        return "Veterinaria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", mascota=" + mascota +
                '}';
    }
}
