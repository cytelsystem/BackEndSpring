package com.dh.odontologica.service;

import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.model.TurnoDTO;
import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.persistence.entity.Turno;
import com.dh.odontologica.persistence.repository.TurnoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    //******************************Metodos*******************************//

    public String guardar(Turno t){
        String respuesta = null;
        if (repository.save(t) != null){
            respuesta = "ok";
        }
        return respuesta;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Turno> buscarPorId(Long id){

        return repository.findById(id);
    }

    public List<TurnoDTO> buscarTodos(){

        List<TurnoDTO> turnos = new ArrayList<>();

        for(Turno turno: repository.findAll()){
            turnos.add(modelMapper.map(turno, TurnoDTO.class));
        }

        return turnos;
    }


    //****************************************************************************//

}
