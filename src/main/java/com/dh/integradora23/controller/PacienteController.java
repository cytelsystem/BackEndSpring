package com.dh.integradora23.controller;

import com.dh.integradora23.model.Paciente;
import com.dh.integradora23.service.PacienteService;
import com.dh.integradora23.service.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    private PacienteService service = new PacienteService();

    @RequestMapping(method = RequestMethod.GET, path = "todos")
    public List<Paciente> getTodosLosPacientes(){
        return service.getTodosLosPacientes();
    }

    @GetMapping("pacientePorEmail")
    public String getPacientePorEmail(@RequestParam String email){

        return service.getPacientePorEmail(email).toString();
    }

    @PostMapping("crear")
    public ResponseEntity<Paciente> crear(@RequestBody Paciente p){

        ResponseEntity respuesta = null;
        try {
            respuesta = ResponseEntity.ok(service.crear(p));
        } catch (ServiceException e) {
            respuesta = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return respuesta;
    }

    @PutMapping("modificar")
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente p){

        ResponseEntity respuesta = null;
        if(p.getId() != null){
            respuesta = ResponseEntity.ok().body(service.modificar(p));
        }else{
            respuesta = ResponseEntity.badRequest().body(p);
        }

        return respuesta;
    }

}
