package com.buengusto.model.dto;

import java.util.Date;
import java.util.List;

public class DetalleDomicilioDTO {
    private int id;
    private Date fecha;
    private String total;
    private List<ProductoDomicilioDTO> productos;
    private float valor;

    public DetalleDomicilioDTO(int id, Date fecha, String total, List<ProductoDomicilioDTO> productos, float valor) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.productos = productos;
        this.valor = valor;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ProductoDomicilioDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDomicilioDTO> productos) {
        this.productos = productos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
