package com.dh.odontologica.service;

import com.dh.odontologica.model.JugadorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JugadorService {

    List<JugadorDTO> jugadores = new ArrayList<>();

    //******************************Constructores************************************//

    public JugadorService(List<JugadorDTO> jugadores) {
        this.jugadores.add(new JugadorDTO("Carlos", "montero"));
        this.jugadores.add(new JugadorDTO("Oscar", "Agudelo"));
    }

    //********************************Metodos**************************************//

    public JugadorDTO buscarPorNombre(String nombre){
        for (JugadorDTO jugadorDTO : jugadores){
            if(jugadorDTO.getNombre().equals(nombre)){
                return jugadorDTO;
            }
        }
        return null;
    }

    public List<JugadorDTO> buscarTodos(){
        return jugadores;
    }

    //***********************************************************************************//




}
