package com.dh.odontologica.controller;

import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.persistence.dao.impl.DomicilioDAOH2;
import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    DomicilioService service;

    @PostMapping("/Crear")
    public ResponseEntity<String> crear(@RequestBody Domicilio domicilio){
        return ResponseEntity.ok(service.guardar(domicilio));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (service.BuscarPorId(id) != null) {
            service.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }

    @PutMapping("/actualizar")
    public ResponseEntity<Domicilio> actualizar(@RequestBody Domicilio domicilio) {
        ResponseEntity<Domicilio> response = null;

        if (service.BuscarPorId(domicilio.))
            response = ResponseEntity.ok(service.guardar(domicilio));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/buscarPorIdo/{id}")
    public ResponseEntity<DomicilioDTO> buscar(@PathVariable Long id) {
        DomicilioDTO odontologo = service.buscarDomicilioPorId(id);

        return ResponseEntity.ok(odontologo);
    }


    @RequestMapping("/ConsultarTodos")
    public ResponseEntity<List<DomicilioDTO>> getTodosDomicilio(){
        return ResponseEntity.ok(service.listarTodosDomicilio());
    }




}
