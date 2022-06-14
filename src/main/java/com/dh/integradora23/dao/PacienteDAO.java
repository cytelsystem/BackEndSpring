package com.dh.integradora23.dao;

import com.dh.integradora23.model.Domicilio;
import com.dh.integradora23.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private List<Paciente> pacientes;

    public PacienteDAO() {
        this.pacientes = new ArrayList<>();
        pacientes.add(new Paciente(1L,"Pérez", "Frailejón Ernesto", "tuamigoelfrailejonernestoperez@mail.org", new Domicilio()));
        pacientes.add(new Paciente(2L,"Pekerman", "José", "lomejorquetuvoelfutbolcolombiano@mail.org", new Domicilio()));
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente crear(Paciente p) {
        pacientes.add(p);
        p.setId(new Long(this.pacientes.size()));

        return p;
    }

    public Paciente getPacientePorId(Paciente p) {

        Long i = getIndexOf(p);

        return i != -1 ? pacientes.get(i.intValue()) : null;
    }

    public Paciente modificar(Paciente datosAModificar) {
        Long index = getIndexOf(datosAModificar);

        Paciente pacienteActual = pacientes.get(index.intValue());

        pacienteActual.setNombre(datosAModificar.getNombre());
        pacienteActual.setApellido(datosAModificar.getApellido());
        pacienteActual.setEmail(datosAModificar.getEmail());

        return pacienteActual;
    }

    private Long getIndexOf(Paciente p){
        Long i = 0L;

        for(i = 0L; i < pacientes.size() ; i++){
            if(pacientes.get(i.intValue()).getId().equals(p.getId())){
                break;
            }
        }

        return i;
    }
}
