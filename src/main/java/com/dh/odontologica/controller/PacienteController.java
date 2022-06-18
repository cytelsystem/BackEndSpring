package com.dh.odontologica.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.dh.odontologica.model.Paciente;
import com.dh.odontologica.persistence.dao.impl.PacienteDAOH2;
import com.dh.odontologica.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PacienteController {


    PacienteService pacienteService = new PacienteService(new PacienteDAOH2());

    @PostMapping("/CrearPaciente")
    public ResponseEntity<Paciente> crearOdontologo(@RequestBody Paciente paciente){

        Paciente prueba = new Paciente();
        prueba = paciente;
        System.out.println(prueba);
        return ResponseEntity.ok(pacienteService.guardaPacienteService(paciente));
    }




//    @RequestMapping("/ConsultarTodosPacientes")
//    public List<Paciente> getTodosLosPacientes(){
//
//        return pacienteService.getTodosLosPacientes();
//    }

//
//    @GetMapping("id")
//    public String getPacientePorEmail(@RequestParam String email){
//
//        return "<h1>" + pacienteService.getPacientePorEmail(email).toString() + "</h1>";
//    }

}
