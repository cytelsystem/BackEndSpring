package com.dh.odontologica.service;


import com.dh.odontologica.model.Odontologo;
import com.dh.odontologica.persistence.dao.Dao;

import java.util.List;


public class OdontologoService {


    private Dao<Odontologo> odontologoIDAO; // comunicacion con la interface

    public OdontologoService(Dao<Odontologo> odontologoIDAO) {
        this.odontologoIDAO = odontologoIDAO;
    }

    //******************************Getter y setter***************************************//
    public Dao<Odontologo> getOdontologoIDAO() {

        return odontologoIDAO;
    }

    public void setOdontologoIDAO(Dao<Odontologo> odontologoIDAO) {

        this.odontologoIDAO = odontologoIDAO;
    }

    //*****************************Metodos************************************************//

    public Odontologo guardaOdontologoService(Odontologo o) {

        return odontologoIDAO.crear(o);
    }


    public void eliminar(Long id) {
        odontologoIDAO.eliminar(id);
    }
    public Odontologo actualizar(Odontologo odontologo) {

        return odontologoIDAO.actualizar(odontologo);
    }


    public Odontologo buscarOdontologoporID(Long id) {

        return odontologoIDAO.consultarPorId(id);
    }

    public List<Odontologo> listarTodosOdontologos() {

          return odontologoIDAO.consultarTodos();

    }


}

