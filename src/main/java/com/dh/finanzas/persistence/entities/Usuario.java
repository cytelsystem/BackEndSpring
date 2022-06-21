package com.dh.finanzas.persistence.entities;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String usuario;
    private String password;


    //**************************************contructores***********************************//

    public Usuario() {

    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    //**************************************Getter y setter*******************************************//
    public Long getId() {
        return id;
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


