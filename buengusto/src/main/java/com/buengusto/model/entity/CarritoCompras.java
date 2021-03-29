package com.buengusto.model.entity;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    public static CarritoCompras carritoCompras;
    private List<ProductoCarrito> productos;
    private float total;

    public static CarritoCompras getCarritoCompras(){
        if(carritoCompras==null){
            carritoCompras = new CarritoCompras();
            carritoCompras.productos=new ArrayList<>();
        }
        return carritoCompras;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void agregarProductoCarritoCompras(ProductoCarrito productoCarrito) {
        this.productos.add(productoCarrito);
        this.total+=productoCarrito.getValor();
    }

    public void actualizarProductoCarritoCompras(int id, int cantidad){
        this.productos.get(id).setCantidad(cantidad);
    }

    public void removerProductoCarritoCompras(ProductoCarrito productoCarrito) {
        this.productos.remove(productoCarrito);
    }


    public List<ProductoCarrito> listarProductoCarritoCompras() {
        return productos ;
    }

    @Override
    public String toString() {
        return "CarritoCompras{" +
                "productos=" + productos +
                ", total=" + total +
                '}';
    }
}
