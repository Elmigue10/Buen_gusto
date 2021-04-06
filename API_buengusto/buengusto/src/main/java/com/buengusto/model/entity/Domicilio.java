package com.buengusto.model.entity;

import java.util.Date;
import java.util.List;

public class Domicilio {

    private int id;
    private Date fecha;
    private List<DetalleDomicilio> productos;

    public Domicilio(int id, Date fecha, List<DetalleDomicilio> productos) {
        this.id = id;
        this.fecha = fecha;
        this.productos = productos;
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

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", productos=" + productos +
                '}';
    }
}
