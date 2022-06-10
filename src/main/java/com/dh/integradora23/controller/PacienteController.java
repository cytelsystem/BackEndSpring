package com.dh.integradora23.controller;

import com.dh.integradora23.model.Paciente;
import com.dh.integradora23.service.PacienteService;
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
