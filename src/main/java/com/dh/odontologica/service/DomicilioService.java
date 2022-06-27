package com.dh.odontologica.service;

import com.dh.odontologica.model.DomicilioDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DomicilioService {

    private Dao<DomicilioDTO> domicilioIdao;

    //***************************Constructor*************************************//

    public DomicilioService(Dao<DomicilioDTO> domicilioIdao) {
        this.domicilioIdao = domicilioIdao;
    }

    //****************************Getter y Setter***********************************//

    public Dao<DomicilioDTO> getDomicilioIdao() {
        return domicilioIdao;
    }

    public void setDomicilioIdao(Dao<DomicilioDTO> domicilioIdao) {
        this.domicilioIdao = domicilioIdao;
    }


    //******************************Metodos*******************************//

    public DomicilioDTO guardarDomicilioService(DomicilioDTO d) {

        return domicilioIdao.crear(d);

    }

    public void eliminar(Long id){

        domicilioIdao.eliminar(id);

    }

    public DomicilioDTO actualizar(DomicilioDTO domicilio){

        return domicilioIdao.actualizar(domicilio);

    }

    public DomicilioDTO buscarDomicilioPorId(Long id){

        return domicilioIdao.consultarPorId(id);
    }

    public List<DomicilioDTO> listarTodosDomicilio(){

        return domicilioIdao.consultarTodos();

    }

    //****************************************************************************//



}
