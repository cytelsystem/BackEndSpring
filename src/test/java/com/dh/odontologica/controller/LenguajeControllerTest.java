package com.dh.odontologica.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class LenguajeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void obtenerLenguajesPorTipo() throws Exception{
                this.mvc.perform(MockMvcRequestBuilders.get("/lenguajes/{tipo}", "PHP")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void obtenerLenguajesPorTipoNotExistente() throws Exception{
                this.mvc.perform(MockMvcRequestBuilders.get("/lenguajes/{tipo}", "sql")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void obtenerTodosLosLenguajes() throws Exception{
        this.mvc.perform(MockMvcRequestBuilders.get("/lenguajes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


}