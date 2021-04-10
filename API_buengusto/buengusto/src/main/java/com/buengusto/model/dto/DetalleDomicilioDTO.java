package com.buengusto.model.dto;

import java.util.Date;
import java.util.List;

public class DetalleDomicilioDTO {
    private int id;
    private Date fecha;
    private String estado;
    private List<ProductoDomicilioDTO> productos;
    private float total;

    public DetalleDomicilioDTO(int id, Date fecha, String estado, List<ProductoDomicilioDTO> productos, float total) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ProductoDomicilioDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDomicilioDTO> productos) {
        this.productos = productos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
