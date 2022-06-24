package com.dh.futbol.Service;

import com.dh.futbol.model.EquipoDTO;
import com.dh.futbol.persistence.entity.Equipo;
import com.dh.futbol.persistence.repository.EquipoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

@Autowired
    private EquipoRepository repository;

@Autowired
private ModelMapper modelMapper;

    //*************************************Metodos**************************************//

    public String guardar(Equipo e){
        String result = null;

        if(repository.save(e) != null){
            result = "OK";
        }

        return result;
    }

    public void eliminar(int id){
        repository.deleteById(id);
    }

    public Optional<Equipo> buscarPorID(int id) {

        return repository.findById(id);
    }

    public List<EquipoDTO> obtenerTodos(){

        List<EquipoDTO> equipos = new ArrayList<>();
        for (Equipo equipo : repository.findAll()) {
            equipos.add(modelMapper.map(equipo, EquipoDTO.class));
        }

        return equipos;
    }

    //********************************************************************************************//

}
