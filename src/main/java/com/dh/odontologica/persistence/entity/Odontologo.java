package com.dh.odontologica.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "Odontologo")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologoSequence")
    @SequenceGenerator(name = "odontologoSequence", sequenceName = "odontologoSequence", allocationSize = 1)

    @Column(name = "id_odontologo", nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String matricula;



    //*****************************Constructores***********************************//

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    //************************Getter y setter***************************//

    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    //******************************************************************//

}
