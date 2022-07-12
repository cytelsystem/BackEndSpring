package com.dh.odontologica.service;

import com.dh.odontologica.controller.TurnoController;
import com.dh.odontologica.exceptions.BadRequestException;
import com.dh.odontologica.exceptions.ResourceNotFoundException;
import com.dh.odontologica.model.TurnoDTO;
import com.dh.odontologica.persistence.entity.Turno;
import com.dh.odontologica.persistence.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TurnoService {
    private Logger logger = Logger.getLogger(TurnoService.class);

    @Autowired
    private TurnoRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    //******************************Metodos*******************************//

    public String guardar(Turno t) throws Exception {


        String respuesta = null;
        if (repository.save(t) != null){
            respuesta = "ok";
        }
        return respuesta;
    }

    public void eliminar(Long id) throws Exception {

        if(buscarPorId(id).isEmpty()) {
            throw new ResourceNotFoundException("No existe este registro con el id" + " " + id);
        }else {
            repository.deleteById(id);
        }

    }

    public Optional<Turno> buscarPorId(Long id) throws Exception{

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
