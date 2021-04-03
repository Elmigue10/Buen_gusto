package com.buengusto.model.entity;

public class Unidad {
    private int id;
    private String unidad;

    public Unidad() {
    }

    public Unidad(int id, String unidad) {
        this.id = id;
        this.unidad = unidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "id=" + id +
                ", unidad='" + unidad + '\'' +
                '}';
    }
}
