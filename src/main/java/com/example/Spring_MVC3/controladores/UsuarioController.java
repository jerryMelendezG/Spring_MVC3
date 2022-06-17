package com.example.Spring_MVC3.controladores;

import com.example.Spring_MVC3.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Moisés");
        usuario2.setApellido("García");
        usuario2.setEmail("moisesgarcia@gmail.com");
        usuario2.setTelefono("82384921");

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Ana");
        usuario3.setApellido("Rivera");
        usuario3.setEmail("riveraana@gmail.com");
        usuario3.setTelefono("83445812");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
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
