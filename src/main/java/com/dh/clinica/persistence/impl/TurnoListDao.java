package com.dh.clinica.persistence.impl;

import com.dh.clinica.persistence.IDao;
import com.dh.clinica.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoListDao implements IDao<Turno> {

    private List<Turno> turnos;

    public TurnoListDao() {
        turnos = new ArrayList<>();
    }

    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        turno.setId(turnos.size());
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        for(Turno turno : turnos){
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {

        for(Turno turno : turnos){
            if(turno.getId().equals(id)){
                turnos.remove(turno);
                return;
            }
        }

    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        eliminar(turno.getId());
        turnos.add(turno);
        return turno;
    }
}
