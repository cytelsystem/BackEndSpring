package com.dh.odontologica.controller;

import com.dh.odontologica.model.OdontologoDTO;
import com.dh.odontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService service;

    @PostMapping("/Crear")
    public ResponseEntity<OdontologoDTO> crearOdontologo(@RequestBody OdontologoDTO odontologo){
        return ResponseEntity.ok(odontologoService.guardaOdontologoService(odontologo));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (odontologoService.buscarOdontologoporID(id) != null) {
            odontologoService.eliminar(id);
//            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }

    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDTO> actualizar(@RequestBody OdontologoDTO odontologo) {
        ResponseEntity<OdontologoDTO> response = null;

        if (odontologo.getId() != null && odontologoService.buscarOdontologoporID(odontologo.getId()) != null)
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable Long id) {
        OdontologoDTO odontologo = odontologoService.buscarOdontologoporID(id);

        return ResponseEntity.ok(odontologo);
    }

    @RequestMapping("/ConsultarTodos")
    public ResponseEntity<List<OdontologoDTO>> getTodosOdontologos(){
        return ResponseEntity.ok(odontologoService.listarTodosOdontologos());
    }



}
