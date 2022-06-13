package com.dh.odontologica.dao;

import com.dh.odontologica.model.Domicilio;
import com.dh.odontologica.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private List<Paciente> pacientes;

    public PacienteDAO() {
        this.pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Pérez", "Frailejón Ernesto", "pf@gmail.com", new Domicilio()));
        pacientes.add(new Paciente("Pekerman", "José", "pj@gmail.comk", new Domicilio()));
    }

    public List<Paciente> getPacientes() {

        return pacientes;
    }

//    public void setPacientes(List<Paciente> pacientes) {
//
//        this.pacientes = pacientes;
//    }

}
