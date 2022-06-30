package com.dh.paqueteria.persistence.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pacientes")
public class Paquete {

    @Id
    private Long id;
    private String codigo;
    private String nombreProducto;
    private String estado;

    private String destinoCalle;
    private Long destinoNumero;
    private String destinolocalidad;
    private String destinoProvincia;

    //********************************************************************************//

    public Paquete() {
    }

    public Paquete(String codigo, String nombreProducto, String estado, String destinoCalle, Long destinoNumero, String destinolocalidad, String destinoProvincia) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.estado = estado;
        this.destinoCalle = destinoCalle;
        this.destinoNumero = destinoNumero;
        this.destinolocalidad = destinolocalidad;
        this.destinoProvincia = destinoProvincia;
    }


    //********************************************************************************//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDestinoCalle() {
        return destinoCalle;
    }

    public void setDestinoCalle(String destinoCalle) {
        this.destinoCalle = destinoCalle;
    }

    public Long getDestinoNumero() {
        return destinoNumero;
    }

    public void setDestinoNumero(Long destinoNumero) {
        this.destinoNumero = destinoNumero;
    }

    public String getDestinolocalidad() {
        return destinolocalidad;
    }

    public void setDestinolocalidad(String destinolocalidad) {
        this.destinolocalidad = destinolocalidad;
    }

    public String getDestinoProvincia() {
        return destinoProvincia;
    }

    public void setDestinoProvincia(String destinoProvincia) {
        this.destinoProvincia = destinoProvincia;
    }


    //********************************************************************************//
}
