package com.campus.gimnasio.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rutinas")
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", nullable = false)
    private NivelRutina nivel;

    @ManyToMany(mappedBy = "rutinas")
    private List<Cliente> clientes = new ArrayList<>();

    public Rutina() {

    }

    public Rutina(String nombre, NivelRutina nivel) {
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
