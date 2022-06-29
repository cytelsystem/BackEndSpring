package com.dh.odontologica.model;


import java.sql.Date;
import java.util.Objects;

public class TurnoDTO {

    private Long id;
    private Date date;


    //***********************************Constructores***************************************//


    //*********************************Getter y setter****************************************//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


//**********************************toString y hashCode***********************************//




    //***************************************Metodos***************************************//





}
