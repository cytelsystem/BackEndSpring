package com.dh.escuela.Controller;

import com.dh.escuela.Service.CursadaService;
import com.dh.escuela.Service.EstudianteService;
import com.dh.escuela.model.CursadaDTO;
import com.dh.escuela.model.EstudianteDTO;
import com.dh.escuela.persistence.entity.Cursada;
import com.dh.escuela.persistence.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @PostMapping("/Crear") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> crear(@RequestBody Estudiante e){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(e) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (service.buscarPorId(id) != null) {

            service.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }


    @PostMapping("/actualizar") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> actualizar(@RequestBody Estudiante e){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(e) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Estudiante> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);

    }


    @GetMapping("/ConsultarTodos") //Ejemplo usando el Dto
    public ResponseEntity<List<EstudianteDTO>> consultarTodos(){

        return ResponseEntity.ok(service.buscarTodos());
    }

}
