package com.dh.storage.controller;

import com.dh.storage.model.Odontologo;
import com.dh.storage.model.Paciente;
import com.dh.storage.model.Turno;
import com.dh.storage.service.OdontologoService;
import com.dh.storage.service.PacienteService;
import com.dh.storage.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class TurnoController {


    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


    @PostMapping("/CrearTurno")
    public ResponseEntity<Turno> crearTurno(@RequestBody Turno turno){

        ResponseEntity<Turno> respuesta;

        Paciente p = pacienteService.buscarPacienteID(turno.getPaciente().getId());
        Odontologo o = odontologoService.buscarOdontologoporID(turno.getOdontologo().getId());

        if(p != null && o != null){
            turnoService.CrearTurno(turno);
            respuesta = ResponseEntity.ok(turno);
        }else{
            respuesta = ResponseEntity.badRequest().body(null);
        }

        System.out.println(p);
        System.out.println(o);
        return respuesta;
    }

    @DeleteMapping("/eliminarTurno/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();

        System.out.println(id);

        ResponseEntity<String> response = null;

        if (turnoService.buscarTurnoID(id) != null) {
            turnoService.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }

    @PutMapping("/actualizarTurno")
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;

        if (turno.getId() != null && turnoService.buscarTurnoID(turno.getId()) != null)
            response = ResponseEntity.ok(turnoService.actualizarTurno(turno));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/buscarPorIdTurno/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Long id) {
        Turno turno = turnoService.buscarTurnoID(id);

        return ResponseEntity.ok(turno);
    }

    @RequestMapping("/ConsultarTodosTurnos")
    public ResponseEntity<List<Turno>> getTodosTurnos(){
        return ResponseEntity.ok(turnoService.listarTodosTurnos());
    }



}
