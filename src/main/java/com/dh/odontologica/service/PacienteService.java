package com.dh.odontologica.service;

import com.dh.odontologica.persistence.dao.Dao;
import com.dh.odontologica.model.Paciente;
import java.util.List;
import java.util.Date;

public class PacienteService {

    private Dao<Paciente> pacienteIDAO; // comunicacion con la interface


    //******************************Constructor***************************************//


    public PacienteService(Dao<Paciente> pacienteIDAO) {
        this.pacienteIDAO = pacienteIDAO;
    }

    //******************************Getter y setter***************************************//


    public Dao<Paciente> getPacienteIDAO() {
        return pacienteIDAO;
    }

    public void setPacienteIDAO(Dao<Paciente> pacienteIDAO) {
        this.pacienteIDAO = pacienteIDAO;
    }

    //*****************************Metodos************************************************//

    public Paciente guardaPacienteService(Paciente o) {
        return pacienteIDAO.crear(o);
    }


    public void eliminar(Long id) {

        pacienteIDAO.eliminar(id);
    }

    public Paciente actualizar(Paciente paciente) {

        return pacienteIDAO.actualizar(paciente);
    }


    public Paciente buscarPacienteID(Long id) {

        return pacienteIDAO.consultarPorId(id);
    }

    public List<Paciente> listarTodosPacientes() {

        return pacienteIDAO.consultarTodos();

    }


}
