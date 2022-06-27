package com.dh.odontologica.service;

import com.dh.odontologica.model.OdontologoDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService {

    private Dao<OdontologoDTO> odontologoIDAO;

    //******************************Constructor***************************************//

    public OdontologoService(Dao<OdontologoDTO> odontologoIDAO) {

        this.odontologoIDAO = odontologoIDAO;
    }

    //******************************Getter y setter***************************************//
    public Dao<OdontologoDTO> getOdontologoIDAO() {

        return odontologoIDAO;
    }

    public void setOdontologoIDAO(Dao<OdontologoDTO> odontologoIDAO) {

        this.odontologoIDAO = odontologoIDAO;
    }

    //*****************************Metodos************************************************//

    public OdontologoDTO guardaOdontologoService(OdontologoDTO o) {

        return odontologoIDAO.crear(o);
    }

    public void eliminar(Long id) {

        odontologoIDAO.eliminar(id);
    }

    public OdontologoDTO actualizar(OdontologoDTO odontologo) {

        return odontologoIDAO.actualizar(odontologo);
    }

    public OdontologoDTO buscarOdontologoporID(Long id) {

        return odontologoIDAO.consultarPorId(id);
    }

    public List<OdontologoDTO> listarTodosOdontologos() {

          return odontologoIDAO.consultarTodos();

    }

    //***********************************************************************************//


}

