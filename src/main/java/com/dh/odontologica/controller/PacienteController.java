package com.dh.odontologica.controller;

import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.model.PacienteDTO;
import com.dh.odontologica.service.DomicilioService;
import com.dh.odontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;
    @Autowired
    DomicilioService domicilioService;


    @PostMapping("/Crear")
    public ResponseEntity<PacienteDTO> crearPaciente(@RequestBody PacienteDTO paciente){

        ResponseEntity<PacienteDTO> respuesta;

        DomicilioDTO d = domicilioService.buscarDomicilioPorId(paciente.getDomicilio().getId());

        System.out.println(d);

        if(d != null){
            pacienteService.guardaPacienteService(paciente);
            respuesta = ResponseEntity.ok(paciente);
        }else{
            respuesta = ResponseEntity.badRequest().body(null);
        }

        System.out.println(paciente);
        return respuesta;
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (pacienteService.buscarPacienteID(id) != null) {
            pacienteService.eliminar(id);
//            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }

    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDTO> actualizar(@RequestBody PacienteDTO paciente) {
        ResponseEntity<PacienteDTO> response = null;

        if (paciente.getId() != null && pacienteService.buscarPacienteID(paciente.getId()) != null)
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Long id) {
        PacienteDTO paciente = pacienteService.buscarPacienteID(id);

        return ResponseEntity.ok(paciente);
    }

    @RequestMapping("/ConsultarTodos")
    public ResponseEntity<List<PacienteDTO>> getTodosPacientes(){
        return ResponseEntity.ok(pacienteService.listarTodosPacientes());
    }



}
