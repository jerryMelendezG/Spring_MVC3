package com.example.Spring_MVC3.controladores;

import com.example.Spring_MVC3.dao.UsuarioDao;
import com.example.Spring_MVC3.dao.UsuarioDaoImp;
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
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){

        try {
            List<Usuario> usuarios = new ArrayList<>();

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection cn = DriverManager.getConnection(url, "registro","12345");
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM USUARIOS order by id asc");

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            Object[] fila = new Object[cantidadColumnas];

            while (rs.next()) {
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(fila[0].toString()));
                usuario.setNombre(fila[1].toString());
                usuario.setApellido(fila[2].toString());
                usuario.setTelefono(fila[3].toString());
                usuario.setEmail(fila[4].toString());
//                usuario.setpa(Integer.parseInt(fila[0].toString()));
                usuarios.add(usuario);
            }
            return usuarios;
        }
        catch (Exception e){
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    @RequestMapping(value = "api/editar-usuario")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
    }

    @RequestMapping(value = "api/eliminar-usuario", method = RequestMethod.DELETE)
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Jerry");
        usuario.setApellido("Meléndez");
        usuario.setEmail("mjerrymoises@gmail.com");
        usuario.setTelefono("84172400");
        return usuario;
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
