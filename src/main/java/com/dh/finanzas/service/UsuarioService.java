package com.dh.finanzas.service;

import com.dh.finanzas.model.MovimientoDto;
import com.dh.finanzas.persistence.entities.Movimiento;
import com.dh.finanzas.persistence.repository.MovimientoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private MovimientoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public String save(Movimiento m){
        String result = null;

        if(repository.save(m) != null){
            result = "OK";
        }

        return result;
    }

    public List<MovimientoDto> obtenerTodos(){

        List<MovimientoDto> movimientos = new ArrayList<>();
        for (Movimiento movimiento : repository.findAll()) {
            movimientos.add(modelMapper.map(movimiento, MovimientoDto.class));
        }

        return movimientos;
    }
}
