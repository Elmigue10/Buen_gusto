package com.buengusto.model.dao;

import com.buengusto.model.dto.ProductoCantidadDTO;
import com.buengusto.model.entity.CarritoCompras;
import com.buengusto.model.entity.ProductoCarrito;

import java.util.Map;

public class CarritoImpl implements ICarrito {

    private CarritoCompras carritoCompras;

    public CarritoImpl() {
        this.carritoCompras = CarritoCompras.getCarritoCompras();
    }

    public CarritoImpl(int id) {
        this.carritoCompras = CarritoCompras.getCarritoCompras(id);
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
    public void vaciar() throws Exception {
        this.carritoCompras.getListaProductos().clear();
        this.carritoCompras.getIdpc().set(0);
    }

    @Override
    public void actualizar(ProductoCantidadDTO producto) throws Exception {
        this.carritoCompras.getListaProductos().get(producto.getId()).setCantidad(producto.getCantidad());
        this.carritoCompras.getListaProductos().get(producto.getId()).setValor(
            this.carritoCompras.getListaProductos().get(producto.getId()).getPrecio()* producto.getCantidad()
        );
    }

    @Override
    public Map<Integer, ProductoCarrito> listar() throws Exception {
        return this.carritoCompras.getListaProductos();
    }


}
