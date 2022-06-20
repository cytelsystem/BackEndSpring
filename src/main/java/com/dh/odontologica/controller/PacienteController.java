package com.dh.odontologica.controller;

import com.dh.odontologica.model.Domicilio;
import com.dh.odontologica.model.Paciente;
import com.dh.odontologica.service.DomicilioService;
import com.dh.odontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PacienteController {

    @Autowired
    PacienteService pacienteService;
    @Autowired
    DomicilioService domicilioService;


    @PostMapping("/CrearPaciente")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente){

        ResponseEntity<Paciente> respuesta;

        Domicilio d = domicilioService.buscarDomicilioPorId(paciente.getDomicilio().getId());

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


    @DeleteMapping("/eliminarPaciente/{id}")
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

    @PutMapping("/actualizarPaciente")
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && pacienteService.buscarPacienteID(paciente.getId()) != null)
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/buscarPorIdPaciente/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPacienteID(id);

        return ResponseEntity.ok(paciente);
    }

    @RequestMapping("/ConsultarTodosPacientes")
    public ResponseEntity<List<Paciente>> getTodosPacientes(){
        return ResponseEntity.ok(pacienteService.listarTodosPacientes());
    }



}
