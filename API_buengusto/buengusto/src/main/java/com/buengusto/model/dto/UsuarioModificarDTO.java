package com.buengusto.model.dto;

public class UsuarioModificarDTO {

    private String usuario;
    private String nombre;
    private String telefono;
    private String direccion;
    private String barrio;

    public UsuarioModificarDTO(String usuario, String nombre, String telefono, String direccion, String barrio) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "UsuarioModificarDTO{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", barrio='" + barrio + '\'' +
                '}';
    }
}
