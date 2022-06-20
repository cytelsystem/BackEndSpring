package com.dh.odontologica.service;

import com.dh.odontologica.model.Turno;
import com.dh.odontologica.persistence.dao.Dao;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TurnoService {

    private Dao<Turno> turnoDao;

    //***********************************Constructor******************************************//

    public TurnoService(Dao<Turno> turnoDao) {
        this.turnoDao = turnoDao;
    }

    //***********************************Getter y Setter********************************************//

    public Dao<Turno> getTurnoDao() {
        return turnoDao;
    }

    public void setTurnoDao(Dao<Turno> turnoDao) {
        this.turnoDao = turnoDao;
    }

    //************************************Metodos**********************************************//

    public Turno CrearTurno(Turno turno){

        return turnoDao.crear(turno);

    }

    public void eliminar(Long id){
        turnoDao.eliminar(id);
    }

    public Turno actualizarTurno(Turno turno){
        return turnoDao.actualizar(turno);
    }

    public Turno buscarTurnoID(Long id){
        return turnoDao.consultarPorId(id);
    }

    public List<Turno> listarTodosTurnos(){
        return turnoDao.consultarTodos();

    }

    //*****************************************************************************************//




}
