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


    public String guardar(Mascota m){
        String result = null;

        if(repository.save(m) != null){
            result = "OK";
        }

        return result;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }


    public Optional<Mascota> buscarPorId(Long id) {

        return repository.findById(id);
    }

    public List<MascotaDTO> obtenerTodos(){

        List<MascotaDTO> mascotas = new ArrayList<>();
        for (Mascota mascota : repository.findAll()) {
            mascotas.add(modelMapper.map(mascota, MascotaDTO.class));
        }

        return mascotas;
    }


    //***************************************************************************//

}
