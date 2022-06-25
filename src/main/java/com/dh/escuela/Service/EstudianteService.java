package com.dh.escuela.Service;

import com.dh.escuela.configuration.MapperConfig;
import com.dh.escuela.model.EstudianteDTO;
import com.dh.escuela.persistence.entity.Estudiante;
import com.dh.escuela.persistence.repository.EstudianteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    //***************************************Metodos*******************************************//

    public String guardar(Estudiante e){
        String resultado = null;

        if (repository.save(e) != null){
            resultado = "ok";
        }
        return resultado;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Estudiante> buscarPorId(Long id){
        return repository.findById(id);
    }

    public List<EstudianteDTO> buscarTodos(){

        List<EstudianteDTO> estudiantes = new ArrayList<>();

        for (Estudiante e: repository.findAll()){
            estudiantes.add(modelMapper.map(e, EstudianteDTO.class));
        }

        return estudiantes;
    }

    //*****************************************************************************************//


}
