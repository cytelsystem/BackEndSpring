package com.dh.odontologica.controller;

import com.dh.odontologica.model.Odontologo;
import com.dh.odontologica.service.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OdontologoController {

    OdontologoService odontologoService = new OdontologoService();

    @RequestMapping("odontologos")
    public List<Odontologo> getTodosOdontologos(){
        return odontologoService.getTodosOdontologos();
    }

    @GetMapping("{id}")
    public Odontologo getOdontologoID(@PathVariable int id){

        return odontologoService.getOdontologosID(id);

    }

}
