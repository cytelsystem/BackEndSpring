package com.dh.futbol.Controller;


import com.dh.futbol.Service.EquipoService;
import com.dh.futbol.model.EquipoDTO;
import com.dh.futbol.persistence.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EquipoController {

    @Autowired
    EquipoService service;


    @PostMapping("/Crear") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> crear(@RequestBody Equipo e){
        ResponseEntity<String> respuesta = null;

        if(service.save(e) != null){
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

        if (service.buscarEquipoID(id) != null) {

            service.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }


    @PostMapping("/actualizar") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> actualizar(@RequestBody Equipo e){
        ResponseEntity<String> respuesta = null;

        if(service.save(e) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Equipo> buscarPorId(@PathVariable int id){
        return service.buscarEquipoID(id);
    }


    @GetMapping("/ConsultarTodos") //Ejemplo usando el Dto
    public ResponseEntity<List<EquipoDTO>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }



}
