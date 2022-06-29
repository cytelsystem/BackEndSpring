package com.dh.odontologica.controller;

import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.model.PacienteDTO;
import com.dh.odontologica.persistence.entity.Paciente;
import com.dh.odontologica.service.DomicilioService;
import com.dh.odontologica.service.PacienteService;
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

    @Autowired
    PacienteService service;
    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/Crear")
    public ResponseEntity<String> crear(@RequestBody Paciente p){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(p) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (service.buscarPorId(id) != null) {

            service.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }


    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Paciente p){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(p) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Paciente> buscarPorId(@PathVariable Long id){

        return service.buscarPorId(id);
    }


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<PacienteDTO>> consultarTodos(){

        return ResponseEntity.ok(service.buscarTodos());
    }


}
