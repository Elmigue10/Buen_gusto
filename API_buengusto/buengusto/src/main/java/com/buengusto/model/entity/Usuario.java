package com.buengusto.model.entity;

public class Usuario {
    private int id;
    private String nombre;
    private String telefono;
    private String usuario;
    private String contraseña;
    private String metodo;
    private Rol rol;
    private String direccion;
    private String barrio;

    public Usuario(int id, String nombre, String telefono, String usuario, String contraseña, String metodo, Rol rol, String direccion, String barrio) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.metodo = metodo;
        this.rol = rol;
        this.direccion = direccion;
        this.barrio = barrio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
}
