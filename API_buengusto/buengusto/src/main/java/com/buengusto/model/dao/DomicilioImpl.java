package com.buengusto.model.dao;

import com.buengusto.model.Conexion;
import com.buengusto.model.entity.Domicilio;
import com.buengusto.model.entity.Producto;
import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class DomicilioImpl implements IDomicilio {


    @Override
    public void crear(Domicilio domicilio) throws Exception {
        int valores=1;
        Connection conn =null;
        PreparedStatement st = null;
        String sql ="";
        try {
            conn= Conexion.getConnection();
            st= conn.prepareStatement(sql);
            st.setDate(valores++, (Date) domicilio.getFecha());
        }catch (Exception ex){
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public List<Domicilio> listar() throws Exception {
        return null;
    }

    @Override
    public Domicilio buscar(int id) throws Exception {
        return null;
    }
}
