package com.dh.odontologica.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="Roles")
@Setter
@Getter
public class Rol {
    @Id
    private Long Id;
    private String name;

}
