package com.dh.veterinaria.Service;

import com.dh.veterinaria.model.VeterinariaDTO;
import com.dh.veterinaria.persistence.entity.Veterinaria;
import com.dh.veterinaria.persistence.repository.VeterinariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinariaService {

@Autowired
    private VeterinariaRepository repository;

@Autowired
private ModelMapper modelMapper;

    //*************************************Metodos**************************************//

    public String guardar(Veterinaria e){
        String result = null;

        if(repository.save(e) != null){
            result = "OK";
        }

        return result;
    }

    public void eliminar(int id){
        repository.deleteById(id);
    }

    public Optional<Veterinaria> buscarPorID(int id) {

        return repository.findById(id);
    }

    public List<VeterinariaDTO> obtenerTodos(){

        List<VeterinariaDTO> equipos = new ArrayList<>();
        for (Veterinaria equipo : repository.findAll()) {
            equipos.add(modelMapper.map(equipo, VeterinariaDTO.class));
        }

        return equipos;
    }

    //********************************************************************************************//

}
