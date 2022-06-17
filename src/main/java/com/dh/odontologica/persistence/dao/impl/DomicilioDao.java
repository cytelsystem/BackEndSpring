package com.dh.odontologica.persistence.dao.impl;

import com.dh.odontologica.model.Domicilio;

public class DomicilioDao {

    public Domicilio findById(Long id) {

        return new Domicilio("calle3", "34", "Bogota", "Cundinamarca");
    }
}
