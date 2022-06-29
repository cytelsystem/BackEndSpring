package com.dh.odontologica.controller;

import com.dh.odontologica.model.TurnoDTO;
import com.dh.odontologica.persistence.entity.Turno;
import com.dh.odontologica.service.OdontologoService;
import com.dh.odontologica.service.PacienteService;
import com.dh.odontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/turnos")
public class TurnoController {


    @Autowired
    private TurnoService service;


    @PostMapping("/Crear")
    public ResponseEntity<String> crear(@RequestBody Turno t){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(t) != null){
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
    public ResponseEntity<String> actualizar(@RequestBody Turno t){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(t) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Turno> buscarPorId(@PathVariable Long id){

        return service.buscarPorId(id);
    }


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<TurnoDTO>> consultarTodos(){

        return ResponseEntity.ok(service.buscarTodos());
    }


}
