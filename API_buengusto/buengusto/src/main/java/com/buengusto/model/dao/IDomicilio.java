package com.buengusto.model.dao;

import com.buengusto.model.entity.DetalleDomicilio;
import com.buengusto.model.entity.Domicilio;
import com.buengusto.model.entity.Producto;

import java.util.List;

public interface IDomicilio {
    void crear(Domicilio domicilio) throws Exception;

    List<Domicilio> listar() throws Exception;

    Domicilio buscar(int id) throws Exception;

}
