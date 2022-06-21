package com.dh.storage.service;

import com.dh.storage.persistence.dao.Dao;
import com.dh.storage.model.Domicilio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DomicilioService {

    private Dao<Domicilio> domicilioIdao;

    //***************************Constructor*************************************//

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
