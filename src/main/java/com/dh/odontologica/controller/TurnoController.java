package com.dh.odontologica.controller;

import com.dh.odontologica.model.OdontologoDTO;
import com.dh.odontologica.model.PacienteDTO;
import com.dh.odontologica.model.TurnoDTO;
import com.dh.odontologica.service.OdontologoService;
import com.dh.odontologica.service.PacienteService;
import com.dh.odontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/turnos")
public class TurnoController {


    @Autowired
    private TurnoService service;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


    @PostMapping("/Crear")
    public ResponseEntity<TurnoDTO> crearTurno(@RequestBody TurnoDTO turno){

        ResponseEntity<TurnoDTO> respuesta;

        PacienteDTO p = pacienteService.buscarPacienteID(turno.getPaciente().getId());
        OdontologoDTO o = odontologoService.buscarOdontologoporID(turno.getOdontologo().getId());

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

    @DeleteMapping("/eliminar/{id}")
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

    @PutMapping("/actualizar")
    public ResponseEntity<TurnoDTO> actualizar(@RequestBody TurnoDTO turno) {
        ResponseEntity<TurnoDTO> response = null;

        if (turno.getId() != null && turnoService.buscarTurnoID(turno.getId()) != null)
            response = ResponseEntity.ok(turnoService.actualizarTurno(turno));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Long id) {
        TurnoDTO turno = turnoService.buscarTurnoID(id);

        return ResponseEntity.ok(turno);
    }

    @RequestMapping("/ConsultarTodos")
    public ResponseEntity<List<TurnoDTO>> getTodosTurnos(){
        return ResponseEntity.ok(turnoService.listarTodosTurnos());
    }



}
