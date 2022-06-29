package com.dh.odontologica.service;

import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.model.PacienteDTO;
import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.persistence.entity.Paciente;
import com.dh.odontologica.persistence.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PacienteService {


    @Autowired
    private PacienteRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    //**********************************Metodos***************************************//

    public String guardar(Paciente p){
        String respuesta = null;
        if (repository.save(p) != null){
            respuesta = "ok";
        }
        return respuesta;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Paciente> buscarPorId(Long id){

        return repository.findById(id);
    }

    public List<PacienteDTO> buscarTodos(){

        List<PacienteDTO> pacientes = new ArrayList<>();

        for(Paciente paciente: repository.findAll()){
            pacientes.add(modelMapper.map(paciente, PacienteDTO.class));
        }

        return pacientes;
    }


    //****************************************************************************//

}
