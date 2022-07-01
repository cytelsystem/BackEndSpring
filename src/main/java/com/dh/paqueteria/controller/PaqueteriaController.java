package com.dh.paqueteria.controller;

import com.dh.paqueteria.model.PaqueteDTO;
import com.dh.paqueteria.persistence.entity.Paquete;
import com.dh.paqueteria.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/paquetes")
public class PaqueteriaController {

        @Autowired
        PaqueteService service;

        @PostMapping("/Crear")
        public ResponseEntity<String> crear(@RequestBody Paquete o){
            ResponseEntity<String> respuesta = null;

            if(service.guardar(o) != null){
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
        public ResponseEntity<String> actualizar(@RequestBody Paquete o){
            ResponseEntity<String> respuesta = null;

            if(service.guardar(o) != null){
                respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
            }else{
                respuesta = ResponseEntity.internalServerError().body("Ooops");
            }

            return respuesta;
        }


        @GetMapping("/buscarPorId/{id}")
        public Optional<Paquete> buscarPorId(@PathVariable Long id){

            return service.buscarPorId(id);
        }

        @GetMapping("/ConsultarTodos")
        public ResponseEntity<List<PaqueteDTO>> consultarTodos(){

            return ResponseEntity.ok(service.buscarTodos());
        }

        @GetMapping("/buscarPorEnCamino")
        public ResponseEntity<List<PaqueteDTO>> buscarPorEnCamino(){

            return ResponseEntity.ok(service.buscarPorEnCamino());
        }

    }
