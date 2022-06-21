package com.dh.storage.entity;


import javax.persistence.*;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastName;


}

