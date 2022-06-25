package com.dh.escuela.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="Cursada")
public class Cursada {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cursada", nullable = false)

    private Long id;
    private double nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
