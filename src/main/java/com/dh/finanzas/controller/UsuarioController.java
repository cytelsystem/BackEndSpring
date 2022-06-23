package com.dh.finanzas.controller;


import com.dh.finanzas.model.MovimientoDto;
import com.dh.finanzas.model.UsuarioDto;
import com.dh.finanzas.persistence.entities.Movimiento;
import com.dh.finanzas.persistence.entities.Usuario;
import com.dh.finanzas.service.EjemploService;
import com.dh.finanzas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("CrearUsuario") //Ejemplo usando directamente la entidad
    public ResponseEntity<String> crear(@RequestBody Usuario u){
        ResponseEntity<String> respuesta = null;

        if(service.save(u) != null){
            respuesta = ResponseEntity.ok("El movimiento fue registrado con éxito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<String> eliminarusuario(@PathVariable int id) {
        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (service.buscarUsuarioporID(id) != null) {

            service.eliminar(id);
//            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }

    @PutMapping("/actualizarUsuario")
    public ResponseEntity<String> Actualizar(@RequestBody Usuario u){

        ResponseEntity<String> respuesta = null;

        if (service.updateUsuario(u) != null){
            respuesta = ResponseEntity.ok("Registro actualizado con exito");
        } else {
            respuesta = ResponseEntity.internalServerError().body("No se actualizo el registro");
        }


        return respuesta;
    }

    @GetMapping("/buscarPorIdUsuario/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable int id){
        return service.buscarUsuarioporID(id);
    }


    @GetMapping("/ConsultarTodosUsuarios") //Ejemplo usando el Dto
    public ResponseEntity<List<UsuarioDto>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }
}
