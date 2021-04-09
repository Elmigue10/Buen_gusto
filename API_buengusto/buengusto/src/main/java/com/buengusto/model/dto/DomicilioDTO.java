package com.buengusto.model.dto;

import java.util.Date;

public class DomicilioDTO {
    private int id;
    private Date fecha;
    private String estado;
    private float valor;

    public DomicilioDTO() {
    }

    public DomicilioDTO(int id, Date fecha, String estado, float valor) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
