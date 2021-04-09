package com.buengusto.model.entity;

import java.util.Date;
import java.util.List;

public class Domicilio {

    private int id;
    private Date fecha;
    private List<DetalleDomicilio> productos;
    private Estado estado;

    public Domicilio(int id, Date fecha, List<DetalleDomicilio> productos, Estado estado) {
        this.id = id;
        this.fecha = fecha;
        this.productos = productos;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetalleDomicilio> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleDomicilio> productos) {
        this.productos = productos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
