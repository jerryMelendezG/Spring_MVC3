package com.example.Spring_MVC3.models;

import lombok.Getter;
import lombok.Setter;

public class Respuesta {
    @Getter @Setter
    private int code;
    @Getter @Setter
    private String status;
    @Getter @Setter
    private String message;

    public Respuesta(){}
}
