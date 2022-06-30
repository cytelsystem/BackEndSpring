package com.dh.paqueteria.model;

public class PaqueteDTO {

    private Long id;
    private String codigo;
    private String nombreProducto;
    private String estado;

    private String destinoCalle;
    private Long destinoNumero;
    private String destinolocalidad;
    private String destinoProvincia;

    //*********************************************************************************//

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


    //*********************************************************************************//

}
