package com.buengusto.model.dao;

import com.buengusto.model.entity.Producto;

import java.util.List;

public interface IProducto {

    void crear(Producto producto) throws Exception;

    void actualizar(Producto producto) throws Exception;

    void eliminar(int id) throws Exception;

    List<Producto> listar() throws Exception;

    List<Producto> listar(String palabra) throws Exception;

    Producto buscar(int id) throws Exception;

}
