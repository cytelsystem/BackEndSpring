package com.dh.odontologica.controller;

import com.dh.odontologica.exceptions.ResourceNotFoundException;
import com.dh.odontologica.model.TurnoDTO;
import com.dh.odontologica.persistence.entity.Odontologo;
import com.dh.odontologica.persistence.entity.Paciente;
import com.dh.odontologica.persistence.entity.Turno;
import com.dh.odontologica.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private Logger logger = Logger.getLogger(TurnoController.class);


    @Autowired
    private TurnoService service;


    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Turno t) throws Exception {
        ResponseEntity<String> respuesta = null;

        Paciente paciente = t.getPaciente();
        Odontologo odontologo = t.getOdontologo();

        if (odontologo.getId() == null) {
            respuesta = ResponseEntity.badRequest().body("Debe ingresar un odontologo");
            logger.info("Registro no creado porque faltaba odontologo");
        } else if (paciente.getId() == null) {
            respuesta = ResponseEntity.badRequest().body("Debe ingresar un paciente");
            logger.info("Registro no creado porque faltaba paciente");
        } else if (t.getDate().isBefore(LocalDate.now())) {
            respuesta = ResponseEntity.badRequest().body("La fecha no puede ser anterior");
            logger.error("Registro no creado porque la fecha es anterior a la actual");
        } else {
            respuesta = ResponseEntity.ok(service.guardar(t) + " " + "Registro creado existosamente");
            logger.error("Registro de turno creado existosamente");
        }


        return respuesta;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws Exception {

        if (buscarPorId(id).isEmpty()){
            throw new ResourceNotFoundException("Turno no existe");
        }
        service.eliminar(id);

        return ResponseEntity.ok("Registro Eliminado ID"+ " " + id) ;
    }


    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Turno t) throws Exception {
        ResponseEntity<String> respuesta = null;

        if(service.guardar(t) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
            logger.info("Turno actualizado exitosamente");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
            logger.error("Turno presenta problemas en la actualizacion");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Turno> buscarPorId(@PathVariable Long id) throws Exception {

        if (service.buscarPorId(id).isEmpty()){
            throw new ResourceNotFoundException("Turno no existe");
        }
        return service.buscarPorId(id);
    }


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<TurnoDTO>> consultarTodos() throws Exception {
        return ResponseEntity.ok(service.buscarTodos());

    }


}
