package com.dh.odontologica.controller;

import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.persistence.dao.impl.DomicilioDAOH2;
import com.dh.odontologica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DomicilioController {

    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/CrearDomicilio")
    public ResponseEntity<DomicilioDTO> crearDomicilio(@RequestBody DomicilioDTO domicilio){
        return ResponseEntity.ok(domicilioService.guardarDomicilioService(domicilio));
    }

    @DeleteMapping("/eliminarDomicilio/{id}")
    public ResponseEntity<String> eliminarDomicilio(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (domicilioService.buscarDomicilioPorId(id) != null) {
            domicilioService.eliminar(id);
//            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }

    @PutMapping("/actualizarDomicilio")
    public ResponseEntity<DomicilioDTO> actualizar(@RequestBody DomicilioDTO domicilio) {
        ResponseEntity<DomicilioDTO> response = null;

        if (domicilio.getId() != null && domicilioService.buscarDomicilioPorId(domicilio.getId()) != null)
            response = ResponseEntity.ok(domicilioService.actualizar(domicilio));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/buscarPorIdDomicilio/{id}")
    public ResponseEntity<DomicilioDTO> buscar(@PathVariable Long id) {
        DomicilioDTO odontologo = domicilioService.buscarDomicilioPorId(id);

        return ResponseEntity.ok(odontologo);
    }


    @RequestMapping("/ConsultarTodosDomicilio")
    public ResponseEntity<List<DomicilioDTO>> getTodosDomicilio(){
        return ResponseEntity.ok(domicilioService.listarTodosDomicilio());
    }




}
