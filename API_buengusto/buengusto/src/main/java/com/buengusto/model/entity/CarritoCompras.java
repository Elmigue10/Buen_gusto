package com.buengusto.model.entity;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CarritoCompras {

    public static CarritoCompras carritoCompras;
    private int idUsuario;
    private Map<Integer,ProductoCarrito> listaProductos;
    private AtomicInteger idpc;
    private float total;

    public static CarritoCompras getCarritoCompras(int id){
        if(carritoCompras==null){
            carritoCompras = new CarritoCompras();
            carritoCompras.listaProductos= new HashMap<>();
            carritoCompras.idpc=new AtomicInteger(0);
            carritoCompras.idUsuario=id;
        }
        return carritoCompras;
    }

    public static CarritoCompras getCarritoCompras(){
        if(carritoCompras==null){
            carritoCompras = new CarritoCompras();
            carritoCompras.listaProductos= new HashMap<>();
            carritoCompras.idpc=new AtomicInteger(0);
        }
        return carritoCompras;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static void setCarritoCompras(CarritoCompras carritoCompras) {
        CarritoCompras.carritoCompras = carritoCompras;
    }

    public Map<Integer, ProductoCarrito> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Map<Integer, ProductoCarrito> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public AtomicInteger getIdpc() {
        return idpc;
    }

    public void setIdpc(AtomicInteger idpc) {
        this.idpc = idpc;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
