package com.dh.futbol.Controller;


import com.dh.futbol.Service.EquipoService;
import com.dh.futbol.Service.JugadorService;
import com.dh.futbol.model.EquipoDTO;
import com.dh.futbol.model.JugadorDTO;
import com.dh.futbol.persistence.entity.Equipo;
import com.dh.futbol.persistence.entity.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    JugadorService service;


    @PostMapping("/Crear") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> crear(@RequestBody Jugador j){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(j) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {

        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (service.buscarPorID(id) != null) {

            service.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }


    @PostMapping("/actualizar") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> actualizar(@RequestBody Jugador j){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(j) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Jugador> buscarPorId(@PathVariable int id){
        return service.buscarPorID(id);
    }


    @GetMapping("/ConsultarTodos") //Ejemplo usando el Dto
    public ResponseEntity<List<JugadorDTO>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }


}
