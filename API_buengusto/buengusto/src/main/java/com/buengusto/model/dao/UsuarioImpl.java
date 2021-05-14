package com.buengusto.model.dao;

import com.buengusto.model.Conexion;
import com.buengusto.model.dto.LoginDTO;
import com.buengusto.model.dto.UsuarioDTO;
import com.buengusto.model.dto.UsuarioModificarDTO;
import com.buengusto.model.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioImpl implements IUsuario{

    @Override
    public void crear(UsuarioDTO usuarioDTO) throws Exception {
        int valores = 1;
        Connection conn = Conexion.getConnection();
        PreparedStatement st= null;
        String sql = "INSERT INTO usuario (nombre, telefono, usuario, contrasena, metodo, fkid_rol, direccion, barrio)\n" +
                "VALUES (?,?,?,?,?,?,?,?);";
        try {
            st=conn.prepareStatement(sql);
            st.setString(valores++,usuarioDTO.getNombre());
            st.setString(valores++,usuarioDTO.getTelefono());
            st.setString(valores++,usuarioDTO.getUsuario());
            st.setString(valores++,usuarioDTO.getPassword());
            st.setString(valores++,"MOD16");
            st.setInt(valores++,2);
            st.setString(valores++,usuarioDTO.getDireccion());
            st.setString(valores++,usuarioDTO.getBarrio());
            st.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(st);
        }
    }

    @Override
    public void actualizar(UsuarioModificarDTO usuarioModificarDTO) throws Exception {
        int valores = 1;
        Connection conn = Conexion.getConnection();
        PreparedStatement st= null;
        String sql = "UPDATE usuario set nombre=?,telefono=?,direccion=?,barrio=? WHERE usuario='"+usuarioModificarDTO.getUsuario()+"';";
        try {
            st=conn.prepareStatement(sql);
            st.setString(valores++,usuarioModificarDTO.getNombre());
            st.setString(valores++,usuarioModificarDTO.getTelefono());
            st.setString(valores++,usuarioModificarDTO.getDireccion());
            st.setString(valores++,usuarioModificarDTO.getBarrio());
            st.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(st);
        }
    }

    @Override
    public void eliminar(String usuario) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        String sql="DELETE FROM usuario WHERE usuario='"+usuario+"';";
        try {
            conn=Conexion.getConnection();
            st=conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(st);
        }
    }

    @Override
    public boolean buscar(String usuario) throws Exception {
        boolean respuesta=true;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql="SELECT usuario FROM usuario WHERE usuario='"+usuario+"';";
        try {
            conn=Conexion.getConnection();
            st=conn.prepareStatement(sql);
            rs=st.executeQuery();
            if(!rs.next()){
                respuesta=false;
            }
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
            Conexion.cerrar(rs);
        }
        return respuesta;
    }

    @Override
    public UsuarioDTO buscarInformacion(LoginDTO loginDTO) throws Exception {
        UsuarioDTO usuarioDTO=null;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql="select nombre,telefono, usuario, contrasena, direccion, barrio, rol from usuario\n" +
                "inner join rol r on usuario.fkid_rol = r.id WHERE usuario='"+loginDTO.getUsuario()+"';";
        try {
            conn=Conexion.getConnection();
            st=conn.prepareStatement(sql);
            rs=st.executeQuery();

            while (rs.next()){
                usuarioDTO = new UsuarioDTO(
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("direccion"),
                        rs.getString("barrio"),
                        rs.getString("rol")
                        );
            }

        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
            Conexion.cerrar(rs);
        }
        return usuarioDTO;
    }

    @Override
    public int buscarId(String usuario) throws Exception {
        int id = 0;
        UsuarioDTO usuarioDTO=null;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql="select id from usuario WHERE usuario='"+usuario+"';";
        try {
            conn=Conexion.getConnection();
            st=conn.prepareStatement(sql);
            rs=st.executeQuery();

            while (rs.next()){
                id=rs.getInt("id");
            }

        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
            Conexion.cerrar(rs);
        }
        return id;
    }
}
