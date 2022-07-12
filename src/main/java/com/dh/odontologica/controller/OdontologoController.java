package com.dh.odontologica.controller;

import com.dh.odontologica.exceptions.ResourceNotFoundException;
import com.dh.odontologica.model.OdontologoDTO;
import com.dh.odontologica.persistence.entity.Odontologo;
import com.dh.odontologica.service.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    OdontologoService service;


    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Odontologo o) throws Exception{
        ResponseEntity<String> respuesta = null;

        if(service.guardar(o) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
            logger.error("No se pudo crear el Odontologo");
        }

        return respuesta;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws Exception {
        service.eliminar(id);
        return ResponseEntity.ok("Registro Eliminado ID"+ " " + id) ;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Odontologo o) throws Exception {
        ResponseEntity<String> respuesta = null;

        if(service.guardar(o) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
            logger.error("No se pudo actualizar el odontologo");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Odontologo> buscarPorId(@PathVariable Long id) throws Exception {

        return service.buscarPorId(id);
    }


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<OdontologoDTO>> consultarTodos() throws Exception {

        return ResponseEntity.ok(service.buscarTodos());
    }



}
