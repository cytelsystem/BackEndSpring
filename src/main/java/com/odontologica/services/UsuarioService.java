package com.odontologica.services;

import com.odontologica.dominio.Usuario;

public class UsuarioService {

    public Usuario crearUsuario(){
        Usuario usuario = new Usuario("hector", 46);

        return usuario;

    }


}
