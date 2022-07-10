package com.dh.odontologica.Controller;

import com.dh.odontologica.model.JugadorDTO;
import com.dh.odontologica.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    JugadorService service;

    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<JugadorDTO>> consultarTodos(){

        return ResponseEntity.ok(service.buscarTodos());
    }
}
