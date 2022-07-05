package com.dh.odontologica.controller;


import com.dh.odontologica.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiController{
    @RequestMapping(value = "/files/{id}")
    public void getFile(@PathVariable("id")long id) throws ResourceNotFoundException {

        if(id <= 0){
            String mensajeError = "No se encuentra ningun archivo con id" + id;
            throw new ResourceNotFoundException(mensajeError);
        }else{

        }
    }
}