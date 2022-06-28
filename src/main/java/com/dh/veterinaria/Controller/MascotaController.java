package com.dh.veterinaria.Controller;


import com.dh.veterinaria.Service.MascotaService;
import com.dh.veterinaria.Service.VeterinariaService;
import com.dh.veterinaria.model.MascotaDTO;
import com.dh.veterinaria.persistence.entity.Mascota;
import com.dh.veterinaria.persistence.entity.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    MascotaService service;

    @Autowired
    VeterinariaService veterinariaService;


    @PostMapping("/Crear")
    public ResponseEntity<Mascota> crear(@RequestBody Mascota j){

        ResponseEntity<Mascota> respuesta;

        System.out.println(j);

        Optional<Veterinaria> v = veterinariaService.buscarPorId(j.getVeterinaria().getId());

        System.out.println(v);


        if(v != null){
            service.guardar(j);
            respuesta = ResponseEntity.ok(j);
        }else{
            respuesta = ResponseEntity.badRequest().body(null);
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


    @PostMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Mascota j){
        ResponseEntity<String> respuesta = null;

        if(service.guardar(j) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }


    @GetMapping("/buscarPorId/{id}")
    public Optional<Mascota> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<MascotaDTO>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }


}
