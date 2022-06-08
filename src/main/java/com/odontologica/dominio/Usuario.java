package com.odontologica.dominio;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;

public class Usuario {

    private String nombre;
    private int edad;


    //********************Constructor**************************************************************//

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //******************************Getter y Setter**********************************************//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //************************************metodos**************************************************//


}
