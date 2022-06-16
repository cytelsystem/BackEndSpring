package com.dh.odontologica.controller;

import com.dh.odontologica.model.Odontologo;
import com.dh.odontologica.persistence.dao.impl.OdontologoDAOH2;
import com.dh.odontologica.service.OdontologoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OdontologoController {



    OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

    @PostMapping("/CrearOdontologo")
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody Odontologo odontologo){
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
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;

        if (odontologo.getId() != null && odontologoService.buscarOdontologoporID(odontologo.getId()) != null)
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }




    @RequestMapping("odontologos")
    public ResponseEntity<List<Odontologo>> getTodosOdontologos(){
        return ResponseEntity.ok(odontologoService.listarTodosOdontologos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Long id) {
        Odontologo odontologo = odontologoService.buscarOdontologoporID(id);

        return ResponseEntity.ok(odontologo);
    }



}
