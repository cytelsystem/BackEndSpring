package com.dh.odontologica.controller;

import com.dh.odontologica.model.Paciente;
import com.dh.odontologica.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    private PacienteService service = new PacienteService();


    @RequestMapping("/")
    public List<Paciente> getTodosLosPacientes(){

        return service.getTodosLosPacientes();
    }


    @GetMapping("id")
    public String getPacientePorEmail(@RequestParam String email){

        return "<h1>" + service.getPacientePorEmail(email).toString() + "</h1>";
    }

}
