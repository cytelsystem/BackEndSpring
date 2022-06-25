package com.dh.escuela.Controller;

import com.dh.escuela.Service.MateriaService;
import com.dh.escuela.model.MateriaDTO;
import com.dh.escuela.persistence.entity.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaService service;

    @PostMapping("/Crear") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> crear(@RequestBody Materia m){
        ResponseEntity<String> respuesta = null;

        System.out.println(m);

        if(service.guardar(m) != null){
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
    public ResponseEntity<String> actualizar(@RequestBody Materia c){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(c) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Materia> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);

    }


    @GetMapping("/ConsultarTodos") //Ejemplo usando el Dto
    public ResponseEntity<List<MateriaDTO>> consultarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

}
