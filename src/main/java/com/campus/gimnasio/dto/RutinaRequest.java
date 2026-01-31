package com.campus.gimnasio.dto;

import com.campus.gimnasio.entity.NivelRutina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RutinaRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El nivel es obligatorio")
    private NivelRutina nivel;

    public RutinaRequest() {

    }

    public RutinaRequest(String nombre, NivelRutina nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
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
