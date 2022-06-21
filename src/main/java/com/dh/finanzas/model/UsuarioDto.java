package com.dh.finanzas.model;

import javax.persistence.*;


public class UsuarioDto {

    private Long id;
    private String usuario;
    private String password;


    //**************************************contructores***********************************//


    //**************************************Getter y setter*******************************************//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //*************************************************************************************************//



}


