package com.buengusto.model.dao;

import com.buengusto.model.Conexion;
import com.buengusto.model.dto.DetalleDomicilioDTO;
import com.buengusto.model.dto.DomicilioDTO;
import com.buengusto.model.dto.ProductoDomicilioDTO;
import com.buengusto.model.entity.CarritoCompras;
import com.buengusto.model.entity.Domicilio;
import com.buengusto.model.entity.Producto;
import com.buengusto.model.entity.ProductoCarrito;
import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DomicilioImpl implements IDomicilio {

    private CarritoCompras carritoCompras;

    public DomicilioImpl() {
        this.carritoCompras = CarritoCompras.getCarritoCompras();
    }


    @Override
    public void crear() throws Exception {
        int valores = 1;
        int indice=0;
        Connection conn = null;
        PreparedStatement st = null;
        String sql =
                "insert into `domicilio` (fecha,fkid_usuario,fkid_estado,valor)\n" +
                        "values (now(),?,?,?);";
        try{
            conn= Conexion.getConnection();
            st = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(valores++,this.carritoCompras.getIdUsuario());
            st.setInt(valores++,1);
            st.setFloat(valores++,this.carritoCompras.getTotal());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                indice=rs.getInt(1);
            }
            crearDetalle(indice);
            this.carritoCompras.getIdpc().set(0);
            this.carritoCompras.getListaProductos().clear();
            this.carritoCompras.setTotal(0);
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
    }

    @Override
    public void crearDetalle(int id) throws Exception {
        int valores = 1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql ="insert into detalle_domicilio (fkid_domicilio, fkid_producto, valor, cantidad)\n" +
                "values (?,?,?,?);";
        try {
            conn= Conexion.getConnection();
            st=conn.prepareStatement(sql);
            for (Map.Entry<Integer, ProductoCarrito> productos: this.carritoCompras.getListaProductos().entrySet()) {
                st.setInt(valores++,id);
                st.setInt(valores++,productos.getValue().getId());
                st.setFloat(valores++,productos.getValue().getValor());
                st.setInt(valores++,productos.getValue().getCantidad());
                st.executeUpdate();
                valores=1;
            }
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
    }

    @Override
    public List<DomicilioDTO> listar(String estado) throws Exception {

        List<DomicilioDTO> domicilios = new ArrayList<>();
        DomicilioDTO domicilio;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql ="SELECT domicilio.id,domicilio.fecha,estado.estado,domicilio.valor " +
                "FROM domicilio INNER JOIN estado ON domicilio.fkid_estado = estado.id " +
                "WHERE estado.estado='"+estado+"';";
        try {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                domicilio = new DomicilioDTO(
                        rs.getInt("id"),
                        rs.getDate("fecha"),
                        rs.getString("estado"),
                        rs.getFloat("valor")
                );
                domicilios.add(domicilio);
            }
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(st);
            Conexion.cerrar(conn);

        }
        return domicilios;
    }



    @Override
    public DetalleDomicilioDTO buscar(int id) throws Exception {

        Domicilio domicilio;
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        ProductoDomicilioDTO producto;
        List<ProductoDomicilioDTO> productos = new ArrayList<>();
        DetalleDomicilioDTO detalle=null;
        int idDomicilio=0;
        Date fecha=null;
        String estado=null;
        float total=0;

        String sql="select domicilio.id, domicilio.fecha,\n" +
                "       estado.estado,\n" +
                "       detalle_domicilio.fkid_producto, producto.nombre, detalle_domicilio.cantidad,detalle_domicilio.valor,\n" +
                "       domicilio.valor as total\n" +
                "FROM domicilio INNER JOIN estado\n" +
                "    ON domicilio.fkid_estado = estado.id\n" +
                "INNER JOIN detalle_domicilio\n" +
                "    ON domicilio.id = detalle_domicilio.fkid_domicilio\n" +
                "INNER JOIN producto on detalle_domicilio.fkid_producto = producto.id\n" +
                "where domicilio.id="+id+";";
        try{
           conn=Conexion.getConnection();
           st=conn.prepareStatement(sql);
           rs=st.executeQuery();

           while (rs.next()){

               idDomicilio = rs.getInt("id");
               fecha = rs.getDate("fecha");
               estado = rs.getString("estado");
               total = rs.getFloat("total");

               producto=new ProductoDomicilioDTO(
                       rs.getInt("fkid_producto"),
                       rs.getString("nombre"),
                       rs.getInt("cantidad"),
                       rs.getFloat("valor")
               );
               productos.add(producto);
           }

            detalle=new DetalleDomicilioDTO(
                   idDomicilio,fecha,estado,productos,total
           );
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
        return detalle;
    }

    @Override
    public void actualizar(int id, int estado) throws Exception {
        int valores=1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql ="UPDATE domicilio SET domicilio.fkid_estado=? WHERE domicilio.id=?;";
        try{
            conn= Conexion.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(valores++,estado);
            st.setInt(valores++,id);
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
    }

}
