package com.dh.veterinaria.Service;


import com.dh.veterinaria.model.MascotaDTO;
import com.dh.veterinaria.persistence.entity.Mascota;
import com.dh.veterinaria.persistence.repository.MascotaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    //*******************************Metodos*************************************//


    public String guardar(Mascota j){
        String result = null;

        if(repository.save(j) != null){
            result = "OK";
        }

        return result;
    }

    public void eliminar(int id){
        repository.deleteById(id);
    }


    public Optional<Mascota> buscarPorID(int id) {

        return repository.findById(id);
    }

    public List<MascotaDTO> obtenerTodos(){

        List<MascotaDTO> jugadores = new ArrayList<>();
        for (Mascota jugador : repository.findAll()) {
            jugadores.add(modelMapper.map(jugador, MascotaDTO.class));
        }

        return jugadores;
    }


    //***************************************************************************//

}
