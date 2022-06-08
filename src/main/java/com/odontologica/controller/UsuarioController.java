package com.odontologica.controller;

import com.odontologica.dominio.Usuario;
import com.odontologica.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService(); // instanciamos usuario services que se le envio la informacion por parametro

    @GetMapping("/")
    public Usuario crearUsuario(){
        return usuarioService.crearUsuario();
    }

    @GetMapping("crear2")
    public Usuario crearUsuario2(){
        Usuario usuario = new Usuario("IVOMME", 38);
        return usuario;
    }

}
