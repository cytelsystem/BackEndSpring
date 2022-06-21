package com.dh.finanzas.service;


import com.dh.finanzas.model.UsuarioDto;
import com.dh.finanzas.persistence.entities.Usuario;
import com.dh.finanzas.persistence.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public String save(Usuario u){
        String result = null;

        if(repository.save(u) != null){
            result = "OK";
        }

        return result;
    }

    public List<UsuarioDto> obtenerTodos(){

        List<UsuarioDto> usuarios = new ArrayList<>();
        for (Usuario usuario : repository.findAll()) {
            usuarios.add(modelMapper.map(usuario, UsuarioDto.class));
        }

        return usuarios;
    }
}
