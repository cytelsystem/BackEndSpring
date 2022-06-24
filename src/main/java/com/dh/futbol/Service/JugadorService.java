package com.dh.futbol.Service;


import com.dh.futbol.model.JugadorDTO;
import com.dh.futbol.persistence.entity.Jugador;
import com.dh.futbol.persistence.repository.JugadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    //*******************************Metodos*************************************//


    public String guardar(Jugador j){
        String result = null;

        if(repository.save(j) != null){
            result = "OK";
        }

        return result;
    }

    public void eliminar(int id){
        repository.deleteById(id);
    }


    public Optional<Jugador> buscarPorID(int id) {

        return repository.findById(id);
    }

    public List<JugadorDTO> obtenerTodos(){

        List<JugadorDTO> jugadores = new ArrayList<>();
        for (Jugador jugador : repository.findAll()) {
            jugadores.add(modelMapper.map(jugador, JugadorDTO.class));
        }

        return jugadores;
    }


    //***************************************************************************//

}
