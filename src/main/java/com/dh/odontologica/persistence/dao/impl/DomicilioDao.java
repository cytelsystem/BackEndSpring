package com.dh.odontologica.persistence.dao.impl;

import com.dh.odontologica.model.Domicilio;

public class DomicilioDao {

    public Domicilio findById(int id) {

        return new Domicilio("Bla", "123", "Santa Marta", "Magdalena");
    }
}