package com.example.Spring_MVC3.models;

import lombok.Getter;
import lombok.Setter;

public class Usuario {
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String telefono;

    @Getter @Setter
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario(){}

}
