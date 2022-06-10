package com.dh.integradora23.dao;

import com.dh.integradora23.model.Domicilio;
import com.dh.integradora23.model.Odontologo;
import com.dh.integradora23.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDao {


    private List<Odontologo> odontologos;



    public OdontologoDao() {
        odontologos = new ArrayList<>();
        odontologos.add(new Odontologo(1, "Carlos", "Moreno", "AB5081"));
        odontologos.add(new Odontologo(2, "Oscar", "Ordonezo", "HJ9674"));
    }

    public List<Odontologo> getOdontologos() {
        return odontologos;
    }
}
