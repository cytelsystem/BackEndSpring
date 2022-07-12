package com.dh.odontologica.controller;

import com.dh.odontologica.configuration.AbstractControllerTest;
import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.service.DomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class DomicilioControllerTest {

    private Logger logger = Logger.getLogger(DomicilioControllerTest.class);

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private DomicilioService service;

    public String crearDomicilio(){
        String res = "ok";
        Domicilio domicilio = new Domicilio("50", "25", "barriosUnidos", "cundinamarca");
        service.guardar(domicilio);
        return res;
    }

    @Test
    void crear() throws Exception {
        MvcResult response = mvc.perform(MockMvcRequestBuilders.post("/domicilios/crear")
               .content(AbstractControllerTest.asJsonString(new Domicilio("8", "20", "Suba", "Cundinamarca")))
               .contentType(MediaType.APPLICATION_JSON)
               .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }


    @Test
    void eliminar() throws Exception{
        this.crearDomicilio();
        mvc.perform(MockMvcRequestBuilders.delete("/domicilios/eliminar/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


//    @Test
//    void buscarPorId() throws Exception {
//        this.crearDomicilio();
//        this.mvc.perform(MockMvcRequestBuilders.get("/domicilios/buscarPorId/{id}", "1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

    @Test
    void buscarPorIdNotFound() throws Exception {
        this.crearDomicilio();
        this.mvc.perform(MockMvcRequestBuilders.get("/domicilios/buscarPorId/{id}", 5)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    void consultarTodos() throws Exception{
        this.crearDomicilio();
        this.mvc.perform(MockMvcRequestBuilders.get("/domicilios/ConsultarTodos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }




    //**************************************************************************//
}