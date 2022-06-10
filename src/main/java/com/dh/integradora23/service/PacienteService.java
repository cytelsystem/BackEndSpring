package com.dh.integradora23.service;

import com.dh.integradora23.dao.PacienteDAO;
import com.dh.integradora23.model.Domicilio;
import com.dh.integradora23.model.Paciente;

import java.util.List;

public class PacienteService {

    PacienteDAO dao = new PacienteDAO();
    DomicilioService domicilioService = new DomicilioService();


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
}
