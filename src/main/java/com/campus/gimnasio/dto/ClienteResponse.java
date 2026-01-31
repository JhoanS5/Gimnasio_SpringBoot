package com.campus.gimnasio.dto;

public class ClienteResponse {

    private Long id;

    private String nombre;

    private String documento;

    private Boolean activo;

    public ClienteResponse() {

    }

    public ClienteResponse(Long id, String nombre, String documento, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
