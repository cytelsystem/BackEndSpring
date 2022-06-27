package com.dh.odontologica.service;

import com.dh.odontologica.model.PacienteDTO;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PacienteService {

    private Dao<PacienteDTO> pacienteIDAO;

    //******************************Constructores***************************************//

    public PacienteService(Dao<PacienteDTO> pacienteIDAO) {
        this.pacienteIDAO = pacienteIDAO;
    }

    //******************************Getter y setter***************************************//

    public Dao<PacienteDTO> getPacienteIDAO() {
        return pacienteIDAO;
    }

    public void setPacienteIDAO(Dao<PacienteDTO> pacienteIDAO) {
        this.pacienteIDAO = pacienteIDAO;
    }

    //*****************************Metodos************************************************//

    public PacienteDTO guardaPacienteService(PacienteDTO o) {
        return pacienteIDAO.crear(o);
    }

    public void eliminar(Long id) {

        pacienteIDAO.eliminar(id);
    }

    public PacienteDTO actualizar(PacienteDTO paciente) {

        return pacienteIDAO.actualizar(paciente);
    }

    public PacienteDTO buscarPacienteID(Long id) {

        return pacienteIDAO.consultarPorId(id);
    }

    public List<PacienteDTO> listarTodosPacientes() {

        return pacienteIDAO.consultarTodos();

    }

    //**************************************************************************************************//

}
