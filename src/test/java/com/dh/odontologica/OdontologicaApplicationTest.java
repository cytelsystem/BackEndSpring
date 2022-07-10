package com.dh.odontologica;

import com.dh.odontologica.controller.LenguajeController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
//@RunWith(SpringRunner.class)
//@WebMvcTest(LenguajeController.class)


@SpringBootTest
@AutoConfigureMockMvc
class OdontologicaApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void buscarTodosLosLenguajesAPI() throws Exception  {
        this.mvc.perform(MockMvcRequestBuilders.get("/lenguajes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

//    @Test
//    void buscarLenguajesTipoAPI() throws Exception  {
//        this.mvc.perform(MockMvcRequestBuilders.get("/lenguajes/{tipo}")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

//    @Test
//    void buscarLenguajesTipoAPINotExistente() throws Exception  {
//        this.mvc.perform(MockMvcRequestBuilders.get("/lenguajes/{tipo}", "pepe")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }


}