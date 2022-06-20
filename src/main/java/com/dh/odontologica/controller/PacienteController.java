package com.dh.odontologica.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.dh.odontologica.model.Domicilio;
import com.dh.odontologica.model.Odontologo;
import com.dh.odontologica.model.Paciente;
import com.dh.odontologica.model.Turno;
import com.dh.odontologica.persistence.dao.impl.DomicilioDAOH2;
import com.dh.odontologica.persistence.dao.impl.OdontologoDAOH2;
import com.dh.odontologica.persistence.dao.impl.PacienteDAOH2;
import com.dh.odontologica.service.DomicilioService;
import com.dh.odontologica.service.OdontologoService;
import com.dh.odontologica.service.PacienteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PacienteController {


    PacienteService pacienteService = new PacienteService(new PacienteDAOH2());
    private DomicilioService domicilioService = new DomicilioService(new DomicilioDAOH2());


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
