package com.dh.integradora23.model;

public class Domicilio {
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
    private int id;

    public Domicilio() {
    }

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.setCalle(calle);
        this.setNumero(numero);
        this.setLocalidad(localidad);
        this.setProvincia(provincia);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getId() {
        return this.id;
    }
}
