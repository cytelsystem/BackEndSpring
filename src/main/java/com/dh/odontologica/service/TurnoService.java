package com.dh.odontologica.service;

import com.dh.odontologica.model.TurnoDTO;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TurnoService {

    private Dao<TurnoDTO> turnoDao;

    //***********************************Constructor******************************************//

    public TurnoService(Dao<TurnoDTO> turnoDao) {
        this.turnoDao = turnoDao;
    }

    //***********************************Getter y Setter********************************************//

    public Dao<TurnoDTO> getTurnoDao() {
        return turnoDao;
    }

    public void setTurnoDao(Dao<TurnoDTO> turnoDao) {
        this.turnoDao = turnoDao;
    }

    //************************************Metodos**********************************************//

    public TurnoDTO CrearTurno(TurnoDTO turno){

        return turnoDao.crear(turno);

    }

    public void eliminar(Long id){
        turnoDao.eliminar(id);
    }

    public TurnoDTO actualizarTurno(TurnoDTO turno){
        return turnoDao.actualizar(turno);
    }

    public TurnoDTO buscarTurnoID(Long id){
        return turnoDao.consultarPorId(id);
    }

    public List<TurnoDTO> listarTodosTurnos(){
        return turnoDao.consultarTodos();

    }

    //*****************************************************************************************//




}
