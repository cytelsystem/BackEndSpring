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

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Veterinaria> buscarPorId(Long id) {

        return repository.findById(id);
    }

    public List<VeterinariaDTO> obtenerTodos(){

        List<VeterinariaDTO> veterinaria = new ArrayList<>();
        for (Veterinaria vet : repository.findAll()) {
            veterinaria.add(modelMapper.map(vet, VeterinariaDTO.class));
        }

        return veterinaria;
    }

    //********************************************************************************************//

}
