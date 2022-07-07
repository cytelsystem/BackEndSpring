package com.dh.odontologica.controller;

import com.dh.odontologica.model.Lenguaje;
import com.dh.odontologica.service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LenguajeController {

    @Autowired
    LenguajeService lenguajeService;

    @GetMapping("/lenguajes/{tipo}")
    public ResponseEntity<?> obtenerLenguajesPorTipo(@PathVariable("tipo") String tipo){
        Lenguaje lenguaje = lenguajeService.buscarPorTipo(tipo);

        if (lenguaje == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(lenguaje, HttpStatus.OK);
    }

    @GetMapping("/lenguajes")
    public ResponseEntity<?> obtenerTodosLosLenguajes(){
        return new ResponseEntity(lenguajeService.buscarTodos(), HttpStatus.OK);

    }
}
