package com.dh.odontologica;

import com.dh.odontologica.controller.LenguajeController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@WebMvcTest(LenguajeController.class)
class OdontologicaApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void buscarTodosLosLenguajesAPI() throws Exception  {
        mvc.perform(MockMvcRequestBuilders.get("/lenguajes"))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    void buscarLenguajesTipoAPI() throws Exception  {
        mvc.perform(MockMvcRequestBuilders.get("/lenguajes/{tipo}"))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    void buscarLenguajesTipoAPINotExistente() throws Exception  {
        mvc.perform(MockMvcRequestBuilders.get("/lenguajes/{tipo}", "pepe"))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

}