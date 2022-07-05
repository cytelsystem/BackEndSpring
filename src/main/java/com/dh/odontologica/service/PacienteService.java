package com.dh.odontologica.service;

import com.dh.odontologica.exceptions.ResourceNotFoundException;
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
    private DomicilioService domicilioService;

    @Autowired
    private ModelMapper modelMapper;


    //**********************************Metodos*****************xx**********************//

    public String guardar(Paciente p){
        String respuesta = null;

        if (p != null) {
            repository.save(p);
            respuesta = "ok";

        }
       return respuesta;
    }


    public void eliminar(Long id)throws ResourceNotFoundException {

        if(buscarPorId(id).isEmpty()) {
            throw new ResourceNotFoundException("No existe este registro con el id" + " " + id);
        }else {
            repository.deleteById(id);
        }

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
