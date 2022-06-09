package com.dh.integradora23.service;

import com.dh.integradora23.dao.DomicilioDao;
import com.dh.integradora23.model.Domicilio;

public class DomicilioService {

    DomicilioDao dao = new DomicilioDao();
    public Domicilio getPorId(int id) {

        return dao.findById(id);
    }
}
