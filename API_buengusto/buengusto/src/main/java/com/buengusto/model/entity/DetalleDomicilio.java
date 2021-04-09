package com.buengusto.model.entity;

public class DetalleDomicilio {
    private int id;
    private float valor;
    private int cantidad;
    private Producto producto;

    public DetalleDomicilio(int id, float valor, int cantidad, Producto producto) {
        this.id = id;
        this.valor = valor;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleDomicilio{" +
                "id=" + id +
                ", valor=" + valor +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}
