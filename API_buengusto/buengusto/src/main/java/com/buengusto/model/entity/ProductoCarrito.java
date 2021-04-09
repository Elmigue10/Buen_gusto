package com.buengusto.model.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductoCarrito extends Producto{
    private int idCarritoCompras;
    private int cantidad;
    private float valor;

    public ProductoCarrito(Producto producto, int cantidad) {
        super(producto.getId(),producto.getNombre(),producto.getPrecio(),producto.getCantidad(), producto.getDescripcion(), producto.getImagen(), producto.getUnidad(), producto.getAgrupacion());
        this.cantidad = cantidad;
        this.valor=this.cantidad*producto.getPrecio();
    }

    public int getIdCarritoCompras() {
        return idCarritoCompras;
    }

    public void setIdCarritoCompras(int idCarritoCompras) {
        this.idCarritoCompras = idCarritoCompras;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ProductoCarrito{" +
                "idCarritoCompras=" + idCarritoCompras +
                ", cantidad=" + cantidad +
                ", valor=" + valor +
                '}';
    }
}
