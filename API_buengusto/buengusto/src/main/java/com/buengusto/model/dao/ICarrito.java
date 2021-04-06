package com.buengusto.model.dao;

import com.buengusto.model.entity.CarritoCompras;
import com.buengusto.model.entity.ProductoCarrito;

import java.util.List;
import java.util.Map;

public interface ICarrito {
    void agregar(ProductoCarrito productoCarrito) throws Exception;

    void eliminar(int id) throws Exception;

    Map<Integer, ProductoCarrito> listar() throws Exception;

    void comprar(CarritoCompras carritoCompras) throws Exception;
}
