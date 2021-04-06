package com.buengusto.model.dao;

import com.buengusto.model.entity.CarritoCompras;
import com.buengusto.model.entity.ProductoCarrito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public class CarritoImpl implements ICarrito {

    private CarritoCompras carritoCompras;

    public CarritoImpl() {
        this.carritoCompras = CarritoCompras.getCarritoCompras();
    }

    @Override
    public void agregar(ProductoCarrito productoCarrito) throws Exception {
        productoCarrito.setIdCarritoCompras(this.carritoCompras.getIdpc().incrementAndGet());
        this.carritoCompras.getListaProductos().put(this.carritoCompras.getIdpc().get(),productoCarrito);
        this.carritoCompras.setTotal(carritoCompras.getTotal()+productoCarrito.getValor());
    }

    @Override
    public void eliminar(int id) throws Exception {
        this.carritoCompras.getListaProductos().remove(id);
    }

    @Override
    public Map<Integer, ProductoCarrito> listar() throws Exception {
        return this.carritoCompras.getListaProductos();
    }

    @Override
    public void comprar(CarritoCompras carritoCompras) throws Exception {
        int valores = 1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql ="";
        
    }
}
