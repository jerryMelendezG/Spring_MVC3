package com.example.Spring_MVC3.dao;

import com.example.Spring_MVC3.models.Respuesta;
import com.example.Spring_MVC3.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    public List<Usuario> getUsuarios();


    public Respuesta eliminar(long id);

    public Usuario getUsuario(long id);
}
