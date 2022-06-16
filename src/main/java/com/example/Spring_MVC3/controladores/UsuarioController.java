package com.example.Spring_MVC3.controladores;

import com.example.Spring_MVC3.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
    }

    @RequestMapping(value = "editar-usuario")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
    }

    @RequestMapping(value = "eliminar-usuario")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
    }

    @RequestMapping(value = "buscar-usuario")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
    }

}
