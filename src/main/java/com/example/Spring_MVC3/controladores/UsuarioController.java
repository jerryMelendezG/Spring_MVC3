package com.example.Spring_MVC3.controladores;

import com.example.Spring_MVC3.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario")
    public Usuario getUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
    }

}
