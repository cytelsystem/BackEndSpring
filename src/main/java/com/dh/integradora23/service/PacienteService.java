package com.dh.integradora23.service;

import com.dh.integradora23.dao.PacienteDAO;
import com.dh.integradora23.model.Domicilio;
import com.dh.integradora23.model.Paciente;

import java.util.List;

public class PacienteService {

    PacienteDAO dao = new PacienteDAO();
    DomicilioService domicilioService = new DomicilioService();

    public PacienteService() {
    }

    public List<Paciente> getTodosLosPacientes(){
        List<Paciente> pacientes = this.dao.getPacientes();

        for (Paciente p: pacientes){
            p.setDomicilio(domicilioService.getPorId(p.getDomicilio().getId()));
        }

        return pacientes;
    }

    public Paciente getPacientePorEmail(String email){
        Paciente respuesta = null;

        for (Paciente p : this.dao.getPacientes()) {
            if(p.getEmail().equals(email)){
                respuesta = p;
            }
        }

        return respuesta;
    }

    public Paciente crear(Paciente p) throws ServiceException{
        //Va a la capa de persistencia y crea un nuevo paciente en la base de datos.
        dao.crear(p);

        if(p.getId() == 0){
            throw new ServiceException();
        }
        return p;
    }

    public Paciente modificar(Paciente p) {

        if(dao.getPacientePorId(p) != null){
            return dao.modificar(p);
        }else{
            //En caso de que no pueda ser modificado
        }

        return null;
    }
}
