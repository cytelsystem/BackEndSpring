package com.dh.odontologica.service;

import com.dh.odontologica.persistence.dao.Dao;
import com.dh.odontologica.model.Domicilio;

import java.util.List;

public class DomicilioService {


    private Dao<Domicilio> domicilioIdao;  // comunicacion con la interface

    //***************************Constructor*************************************//


    public DomicilioService() {

    }

    public DomicilioService(Dao<Domicilio> domicilioIdao) {
        this.domicilioIdao = domicilioIdao;
    }


    //****************************Getter y Setter***********************************//

    public Dao<Domicilio> getDomicilioIdao() {
        return domicilioIdao;
    }

    public void setDomicilioIdao(Dao<Domicilio> domicilioIdao) {
        this.domicilioIdao = domicilioIdao;
    }


    //******************************Metodos*******************************//

    public Domicilio guardarDomicilioService(Domicilio d) {

        return domicilioIdao.crear(d);

    }

    public void eliminar(Long id){

        domicilioIdao.eliminar(id);

    }

    public Domicilio actualizar(Domicilio domicilio){

        return domicilioIdao.actualizar(domicilio);

    }

    public Domicilio buscarDomicilioPorId(Long id){

        return domicilioIdao.consultarPorId(id);
    }

    public List<Domicilio> listarTodosDomicilio(){

        return domicilioIdao.consultarTodos();

    }


    //****************************************************************************//



}
