package com.dh.odontologica.controller;

import ch.qos.logback.core.net.ObjectWriter;

import com.dh.odontologica.configuration.AbstractControllerTest;
import com.dh.odontologica.model.DomicilioDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class DomicilioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void crear() throws Exception {
        DomicilioDTO domicilioDTO = new DomicilioDTO("8", "20", "Suba", "Cundinamarca");

        this.mvc.perform(MockMvcRequestBuilders.post("/domicilio/crear")
                .content(AbstractControllerTest.asJsonString(domicilioDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



    @Test
    void eliminar() throws Exception{
    }

    @Test
    void actualizar() throws Exception{
    }

    @Test
    void buscarPorId() throws Exception{
    }

    @Test
    void consultarTodos() throws Exception{
    }


    //**************************************************************************//


    //**************************************************************************//
}