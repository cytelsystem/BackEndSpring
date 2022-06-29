package com.dh.odontologica.service;

import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.persistence.repository.DomicilioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DomicilioService {

    @Autowired
    private DomicilioRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    //******************************Metodos*******************************//

    public String guardar(Domicilio d){
        String respuesta = null;
        if (repository.save(d) != null){
            respuesta = "ok";
        }
        return respuesta;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Domicilio> buscarPorId(Long id){

        return repository.findById(id);
    }

    public List<DomicilioDTO> buscarTodos(){

        List<DomicilioDTO> domicilios = new ArrayList<>();

        for(Domicilio domicilio: repository.findAll()){
            domicilios.add(modelMapper.map(domicilio, DomicilioDTO.class));
        }

        return domicilios;
    }


    //****************************************************************************//



}
