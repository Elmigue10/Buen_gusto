package com.buengusto.model.entity;

public class Agrupacion {
    private int id;
    private String agrupacion;

    public Agrupacion() {
    }

    public Agrupacion(int id, String agrupacion) {
        this.id = id;
        this.agrupacion = agrupacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgrupacion() {
        return agrupacion;
    }

    public void setAgrupacion(String agrupacion) {
        this.agrupacion = agrupacion;
    }

    @Override
    public String toString() {
        return "Agrupacion{" +
                "id=" + id +
                ", agrupacion='" + agrupacion + '\'' +
                '}';
    }
}
