package com.campus.gimnasio.dto;

import com.campus.gimnasio.entity.NivelRutina;

import java.util.List;

public class RutinaResponse {

    private Long id;

    private String nombre;

    private NivelRutina nivel;

    public RutinaResponse() {

    }

    public RutinaResponse(Long id, String nombre, NivelRutina nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
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

    public NivelRutina getNivel() {
        return nivel;
    }

    public void setNivel(NivelRutina nivel) {
        this.nivel = nivel;
    }
}
