package com.dh.odontologica.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Date;


@Document(collection = "Turno")
public class Turno {

    @Id
    private Long id;

    private Date date;


    //***********************************Constructores***************************************//

    public Turno() {
    }

    public Turno(Date date) {
        this.date = date;
    }
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


    //***************************************************************************************//


}
