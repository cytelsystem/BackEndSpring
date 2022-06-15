package com.dh.clinica.service;

import com.dh.clinica.persistence.IDao;
import com.dh.clinica.model.Turno;

import java.util.List;

public class TurnoService {

    private IDao<Turno> turnoDao;

    public TurnoService(IDao<Turno> turnoDao) {
        this.turnoDao = turnoDao;
    }

    public Turno registrarTurno(Turno turno){
        return turnoDao.guardar(turno);
    }
    public List<Turno> listar(){
        return turnoDao.buscarTodos();
    }


}
