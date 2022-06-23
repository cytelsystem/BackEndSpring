package com.dh.finanzas.service;


import com.dh.finanzas.model.UsuarioDto;
import com.dh.finanzas.persistence.entities.Usuario;
import com.dh.finanzas.persistence.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Optional<Usuario> buscarUsuarioporID(int id) {

        return repository.findById(id);
    }

    public String save(Usuario u){
        String result = null;

        if(repository.save(u) != null){
            result = "OK";
        }

        return result;
    }

    public void eliminar(int id){
        repository.deleteById(id);
    }

    public List<UsuarioDto> obtenerTodos(){

        List<UsuarioDto> usuarios = new ArrayList<>();
        for (Usuario usuario : repository.findAll()) {
            usuarios.add(modelMapper.map(usuario, UsuarioDto.class));
        }

        return usuarios;
    }


    public String updateUsuario(Usuario u){
        String result = null;

        if(repository.save(u) != null){
            result = "OK";
        }

        return result;
    }
}
