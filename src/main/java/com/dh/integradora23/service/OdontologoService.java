package com.dh.integradora23.service;

import com.dh.integradora23.dao.OdontologoDao;
import com.dh.integradora23.model.Odontologo;
import com.dh.integradora23.model.Paciente;

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
