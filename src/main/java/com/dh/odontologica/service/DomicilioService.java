package com.dh.odontologica.service;

import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.persistence.repository.DomicilioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DomicilioService {

    private DomicilioRepository repository;


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

    public Optional<Domicilio> BuscarPorId(Long id){
        return repository.findById(id);
    }

    public List





    //****************************************************************************//



}
