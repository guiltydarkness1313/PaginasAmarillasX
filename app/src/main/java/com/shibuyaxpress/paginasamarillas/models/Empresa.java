package com.shibuyaxpress.paginasamarillas.models;

/**
 * Created by paulf on 21-Sep-17.
 */

public class Empresa {
    private int id;
    private String rubro;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String url;
    private String logo;
    private String info;

    public Empresa(){

    }

    public Empresa(int id, String rubro, String nombre, String direccion, String telefono, String correo, String url, String logo, String info) {
        this.id = id;
        this.rubro = rubro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.url = url;
        this.logo = logo;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
