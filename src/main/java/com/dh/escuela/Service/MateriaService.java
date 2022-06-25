package com.dh.escuela.Service;

import com.dh.escuela.model.MateriaDTO;
import com.dh.escuela.persistence.entity.Materia;
import com.dh.escuela.persistence.repository.MateriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    private MateriaRepository repository;
    private ModelMapper modelMapper;

    //*****************************Metodos*******************************************//

    public String guardar(Materia m){
        String resultado = null;

        if (repository.save(m) != null){
            resultado = "ok";
        }

        return resultado;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Materia> buscarPorId(Long id){
        return repository.findById(id);
    }

    public List<MateriaDTO> buscarTodos(){

        List<MateriaDTO> materias = new ArrayList<>();
        for (Materia m: repository.findAll()){
            materias.add(modelMapper.map(m, MateriaDTO.class));
        }

        return materias;
    }
    //***************************************************************************************//


}
