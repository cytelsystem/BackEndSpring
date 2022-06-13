package com.dh.odontologica.service;

import com.dh.odontologica.dao.OdontologoDao;
import com.dh.odontologica.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private OdontologoDao odontologoDao = new OdontologoDao();

    public List<Odontologo> getTodosOdontologos() {
        return this.odontologoDao.getOdontologos();
    }


    public Odontologo getOdontologosID(int id) {

        Odontologo respuesta = null;

        for (Odontologo p : this.odontologoDao.getOdontologos()) {
            if(p.getId() == id){

                respuesta = p;
            }
        }

        return respuesta;
    }


}
