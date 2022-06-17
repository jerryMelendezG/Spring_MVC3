package com.example.Spring_MVC3.dao;

import com.example.Spring_MVC3.models.Respuesta;
import com.example.Spring_MVC3.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
//    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
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
            cn.close();
            s.close();
            rs.close();
            return usuarios;
        }
        catch (Exception e){
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    @Override
    public Respuesta eliminar(long id) {
        Respuesta resp = new Respuesta();

        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection cn = DriverManager.getConnection(url, "registro","12345");
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery("delete from usuarios where id = " + id);

            resp.setCode(200);
            resp.setStatus("success");
            resp.setMessage("Usuario eliminado correctamente");

            cn.close();
            s.close();
            rs.close();
        }
        catch (Exception e){
            resp.setCode(400);
            resp.setStatus("Error");
            resp.setMessage("Error al eliminar el usuario: " + e.toString());
        }

        return resp;
    }

    @Override
    public Usuario getUsuario(long id) {
        try {

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection cn = DriverManager.getConnection(url, "registro","12345");
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery("select * from usuarios where id = " + id);

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

                return usuario;
            }
            return null;
        }
        catch (Exception e){
            System.out.println("Error: " + e.toString());
            return null;
        }
    }
}
