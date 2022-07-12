package com.dh.odontologica.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalException {

    public static Logger logger = Logger.getLogger(GlobalException.class);

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> badRequest(BadRequestException br){
        logger.debug(br.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getMessage());
    }
    @ExceptionHandler({ChangeSetPersister.NotFoundException.class})
    public ResponseEntity<String> notFound(ChangeSetPersister.NotFoundException nf){
        logger.debug(nf.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nf.getMessage());
    }

}

