package com.dh.odontologica.controller;

import com.dh.odontologica.exceptions.ResourceNotFoundException;
import com.dh.odontologica.model.PacienteDTO;
import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.persistence.entity.Paciente;
import com.dh.odontologica.service.DomicilioService;
import com.dh.odontologica.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    PacienteService service;
    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Paciente p) throws Exception{
        ResponseEntity<String> respuesta = null;

        if(service.guardar(p) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
            logger.error("no se pudo crear el paciente");
        }

        return respuesta;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws Exception {

        service.eliminar(id);

        return ResponseEntity.ok("Registro Eliminado ID"+ " " + id) ;

    }


    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Paciente p) throws Exception{
        ResponseEntity<String> respuesta = null;

        if(service.guardar(p) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
            logger.error("no se pudo actualizar el paciente");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Paciente> buscarPorId(@PathVariable Long id) throws Exception{

        return service.buscarPorId(id);
    }


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<PacienteDTO>> consultarTodos() throws Exception{

        return ResponseEntity.ok(service.buscarTodos());
    }


}
