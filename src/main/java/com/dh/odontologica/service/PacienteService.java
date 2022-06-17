package com.dh.odontologica.service;

import com.dh.odontologica.persistence.dao.impl.PacienteDAO;
import com.dh.odontologica.model.Paciente;

import java.util.List;

public class PacienteService {

    PacienteDAO dao = new PacienteDAO(); //donde esta la base de datos paciente
    DomicilioService domicilioService = new DomicilioService();


    public List<Paciente> getTodosLosPacientes(){
        List<Paciente> pacientes = this.dao.getPacientes();

        for (Paciente p: pacientes){
//            p.setDomicilio(domicilioService.getPorId(p.getDomicilio().getId()));

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
}
