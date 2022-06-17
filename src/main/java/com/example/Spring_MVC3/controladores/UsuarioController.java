package com.example.Spring_MVC3.controladores;

import com.example.Spring_MVC3.dao.UsuarioDao;
import com.example.Spring_MVC3.dao.UsuarioDaoImp;
import com.example.Spring_MVC3.models.Respuesta;
import com.example.Spring_MVC3.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable long id){
        return usuarioDao.getUsuario(id);
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/editar-usuario")
    public void editar(){

    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public Respuesta eliminar(@PathVariable long id){
        return usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "api/buscar-usuario")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
    }

}
