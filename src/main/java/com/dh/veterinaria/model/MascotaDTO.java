package com.dh.veterinaria.model;

import com.dh.veterinaria.persistence.entity.Veterinaria;

public class MascotaDTO {

    private Long id;
    private String nombre;
    private String tipo;
    private Veterinaria veterinariaId;


    //*************************************Contructores****************************************//


    //*************************************Getter y Setter*********************************************//

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Veterinaria getVeterinariaId() {
        return veterinariaId;
    }

    public void setVeterinariaId(Veterinaria veterinariaId) {
        this.veterinariaId = veterinariaId;
    }


    //**************************************Metodos*********************************************//

    @Override
    public String toString() {
        return "MascotaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", veterinariaId=" + veterinariaId +
                '}';
    }


    //************************************************************************************************//

}
