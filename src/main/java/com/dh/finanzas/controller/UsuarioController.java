package com.dh.finanzas.controller;


import com.dh.finanzas.model.MovimientoDto;
import com.dh.finanzas.persistence.entities.Movimiento;
import com.dh.finanzas.service.EjemploService;
import com.dh.finanzas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("/usuario/crear") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> crear(@RequestBody Movimiento m){
        ResponseEntity<String> respuesta = null;

        if(service.save(m) != null){
            respuesta = ResponseEntity.ok("El movimiento fue registrado con éxito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    @GetMapping("/usuario/todos") //Ejemplo usando el Dto
    public ResponseEntity<List<MovimientoDto>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }
}
