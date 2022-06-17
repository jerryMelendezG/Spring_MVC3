package com.example.Spring_MVC3.dao;

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
            ResultSet rs = s.executeQuery("select * from usuarios order by id asc");

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            Object[] fila = new Object[cantidadColumnas];

            while (rs.next()) {

                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(fila[0].toString()));
                usuario.setId(Integer.parseInt(fila[0].toString()));
                usuario.setId(Integer.parseInt(fila[0].toString()));
                usuario.setId(Integer.parseInt(fila[0].toString()));
                usuario.setId(Integer.parseInt(fila[0].toString()));
                usuario.setId(Integer.parseInt(fila[0].toString()));
                usuarios.add(usuario);
            }
            return usuarios;
        }
        catch (Exception e){
            return null;
        }
    }
}
