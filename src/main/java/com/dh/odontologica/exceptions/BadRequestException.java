package com.dh.odontologica.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception{

    public BadRequestException(String mensaje){
        super(mensaje);
    }
}