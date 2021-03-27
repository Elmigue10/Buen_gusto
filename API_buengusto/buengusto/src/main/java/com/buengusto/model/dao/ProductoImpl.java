package com.buengusto.model.dao;

import com.buengusto.model.Conexion;
import com.buengusto.model.entity.Agrupacion;
import com.buengusto.model.entity.Producto;
import com.buengusto.model.entity.Unidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoImpl implements IDatos {
    @Override
    public void crear(Producto producto) throws Exception {
        int valores = 1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql = "insert into producto (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) values(?,?,?,?,?,?,?);";
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(valores++, producto.getNombre());
            st.setFloat(valores++, producto.getPrecio());
            st.setInt(valores++, producto.getCantidad());
            st.setString(valores++, producto.getDescripcion());
            st.setString(valores++, producto.getImagen());
            st.setInt(valores++, producto.getUnidad().getId());
            st.setInt(valores++, producto.getAgrupacion().getId());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
    }

    @Override
    public void actualizar(Producto producto) throws Exception {
        int valores = 1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql = "UPDATE producto set nombre=?,precio=?,cantidad=?,descripcion=?,imagen=?,fkid_unidad=?,fkid_agrupacion=? WHERE id=" + producto.getId() + ";";
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(valores++, producto.getNombre());
            st.setFloat(valores++, producto.getPrecio());
            st.setInt(valores++, producto.getCantidad());
            st.setString(valores++, producto.getDescripcion());
            st.setString(valores++, producto.getImagen());
            st.setInt(valores++, producto.getUnidad().getId());
            st.setInt(valores++, producto.getAgrupacion().getId());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        String sql = "DELETE FROM producto WHERE id=" + id + ";";
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
    }

    @Override
    public List<Producto> listar() throws Exception {
        List<Producto> productos = new ArrayList<>();
        Producto producto = null;
        Agrupacion agrupacion = null;
        Unidad unidad = null;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT producto.id,producto.nombre,producto.precio,producto.cantidad,producto.descripcion,producto.imagen,producto.fkid_unidad,unidad.unidad,producto.fkid_agrupacion, agrupacion.agrupacion \n" +
                "FROM producto \n" +
                "INNER JOIN Agrupacion ON producto.fkid_agrupacion = Agrupacion.id\n" +
                "INNER JOIN Unidad ON producto.fkid_unidad = unidad.id;";
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                unidad = new Unidad(
                        rs.getInt("fkid_unidad"),
                        rs.getString("unidad")
                );
                agrupacion = new Agrupacion(
                        rs.getInt("fkid_agrupacion"),
                        rs.getString("agrupacion")
                );
                producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getFloat("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("descripcion"),
                        rs.getString("imagen"),
                        unidad, agrupacion
                );
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
        return productos;
    }

    @Override
    public List<Producto> listar(String palabra) throws Exception {
        List<Producto> productos = new ArrayList<>();
        Producto producto = null;
        Agrupacion agrupacion = null;
        Unidad unidad = null;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT producto.id,producto.nombre,producto.precio,producto.cantidad,producto.descripcion,producto.imagen,producto.fkid_unidad,unidad.unidad,producto.fkid_agrupacion, agrupacion.agrupacion \n" +
                "FROM producto \n" +
                "INNER JOIN Agrupacion ON producto.fkid_agrupacion = Agrupacion.id\n" +
                "INNER JOIN Unidad ON producto.fkid_unidad = unidad.id \n" +
                "WHERE producto.descripcion LIKE '%" + palabra + "%'";
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                unidad = new Unidad(
                        rs.getInt("fkid_unidad"),
                        rs.getString("unidad")
                );
                agrupacion = new Agrupacion(
                        rs.getInt("fkid_agrupacion"),
                        rs.getString("agrupacion")
                );
                producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getFloat("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("descripcion"),
                        rs.getString("imagen"),
                        unidad, agrupacion
                );
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
        return productos;
    }


    @Override
    public Producto buscar(int id) throws Exception {
        Producto producto = null;
        Agrupacion agrupacion = null;
        Unidad unidad = null;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT producto.id,producto.nombre,producto.precio,producto.cantidad,producto.descripcion,producto.imagen,producto.fkid_unidad,unidad.unidad,producto.fkid_agrupacion, agrupacion.agrupacion \n" +
                "FROM producto \n" +
                "INNER JOIN Agrupacion ON producto.fkid_agrupacion = Agrupacion.id\n" +
                "INNER JOIN Unidad ON producto.fkid_unidad = unidad.id \n" +
                "WHERE producto.id = " + id + ";";
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                unidad = new Unidad(
                        rs.getInt("fkid_unidad"),
                        rs.getString("unidad")
                );
                agrupacion = new Agrupacion(
                        rs.getInt("fkid_agrupacion"),
                        rs.getString("agrupacion")
                );
                producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getFloat("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("descripcion"),
                        rs.getString("imagen"),
                        unidad, agrupacion
                );
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
        return producto;
    }
}
