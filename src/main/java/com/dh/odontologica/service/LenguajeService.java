package com.dh.odontologica.service;

import com.dh.odontologica.model.Lenguaje;
import com.dh.odontologica.persistence.repository.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LenguajeService {


    List<Lenguaje> lenguajes = new ArrayList<>();

    //******************************Constructores************************************//

    public LenguajeService(List<Lenguaje> lenguajes) {
        this.lenguajes.add(new Lenguaje("Java", true));
        this.lenguajes.add(new Lenguaje("PHP", false));
    }


    //********************************Metodos**************************************//

    public Lenguaje buscarPorTipo(String tipo){
        for (Lenguaje lenguaje: lenguajes){
            if(lenguaje.getTipo().equals(tipo)){
                return lenguaje;
            }
        }
        return null;
    }

    public List<Lenguaje> buscarTodos(){
        return lenguajes;
    }


    //***********************************************************************************//
}
