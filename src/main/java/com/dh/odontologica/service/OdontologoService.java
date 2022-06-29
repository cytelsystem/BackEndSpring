package com.dh.odontologica.service;

import com.dh.odontologica.model.OdontologoDTO;
import com.dh.odontologica.persistence.entity.Odontologo;
import com.dh.odontologica.persistence.repository.OdontologoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    //******************************Metodos*******************************//

    public String guardar(Odontologo o){
        String respuesta = null;
        if (repository.save(o) != null){
            respuesta = "ok";
        }
        return respuesta;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Odontologo> buscarPorId(Long id){

        return repository.findById(id);
    }

    public List<OdontologoDTO> buscarTodos(){

        List<OdontologoDTO> odontologos = new ArrayList<>();

        for(Odontologo odontologo: repository.findAll()){
            odontologos.add(modelMapper.map(odontologo, OdontologoDTO.class));
        }

        return odontologos;
    }


    //****************************************************************************//


}

