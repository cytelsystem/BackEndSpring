package com.dh.odontologica.configuration;
import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.persistence.entity.Domicilio;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractControllerTest<T> {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}



