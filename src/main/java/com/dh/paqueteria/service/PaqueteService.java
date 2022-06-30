package com.dh.paqueteria.service;

import com.dh.paqueteria.model.PaqueteDTO;
import com.dh.paqueteria.persistence.entity.Paquete;
import com.dh.paqueteria.persistence.repository.PaqueteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    //******************************************************************************//


    public String guardar(Paquete p){
        String respuesta = null;
        if (repository.save(p) != null){
            respuesta = "ok";
        }
        return respuesta;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Paquete> buscarPorId(Long id){

        return repository.findById(id);
    }

    public List<PaqueteDTO> buscarTodos(){

        List<PaqueteDTO> pacientes = new ArrayList<>();

        for(Paquete paquete: repository.findAll()){
            pacientes.add(modelMapper.map(paquete, PaqueteDTO.class));
        }

        return pacientes;
    }


    //******************************************************************************//
}
