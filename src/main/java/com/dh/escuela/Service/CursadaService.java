package com.dh.escuela.Service;


import com.dh.escuela.model.CursadaDTO;
import com.dh.escuela.persistence.entity.Cursada;
import com.dh.escuela.persistence.repository.CursadaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursadaService {

    @Autowired
    private CursadaRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    //****************************Metodos************************************//


    public String guardar(Cursada c){

        String resultado = null;

        if (repository.save(c) !=null){
            resultado = "OK";
        }
        return resultado;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Cursada> buscarPorId(Long id){
        return repository.findById(id);
    }

    public List<CursadaDTO> buscarTodos(){

        List<CursadaDTO> cursadas = new ArrayList<>();
        for (Cursada c: repository.findAll()){
            cursadas.add(modelMapper.map(c, CursadaDTO.class));
        }
        return cursadas;
    }

    //******************************************************************************//
}
