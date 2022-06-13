package com.dh.odontologica.service;

import com.dh.odontologica.dao.DomicilioDao;
import com.dh.odontologica.model.Domicilio;

public class DomicilioService {

    DomicilioDao dao = new DomicilioDao();
    public Domicilio getPorId(int id) {

        return dao.findById(id);
    }
}
