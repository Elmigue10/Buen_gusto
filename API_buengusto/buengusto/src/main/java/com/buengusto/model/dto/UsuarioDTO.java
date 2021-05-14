package com.buengusto.model.dto;

import com.buengusto.model.entity.Rol;

public class UsuarioDTO {

    private String nombre;
    private String telefono;
    private String usuario;
    private String password;
    private String direccion;
    private String barrio;
    private String rol;

    public UsuarioDTO(String nombre, String telefono, String usuario, String password, String direccion, String barrio, String rol) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
        this.direccion = direccion;
        this.barrio = barrio;
        this.rol = rol;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
