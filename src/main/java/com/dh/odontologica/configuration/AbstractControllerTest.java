package com.dh.odontologica.configuration;
import com.dh.odontologica.model.DomicilioDTO;
import com.dh.odontologica.persistence.entity.Domicilio;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractControllerTest<T> {


    public static String asJsonString(DomicilioDTO domicilioDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(domicilioDTO);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
