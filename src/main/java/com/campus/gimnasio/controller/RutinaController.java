package com.campus.gimnasio.controller;

import com.campus.gimnasio.dto.ClienteResponse;
import com.campus.gimnasio.dto.RutinaRequest;
import com.campus.gimnasio.dto.RutinaResponse;
import com.campus.gimnasio.service.RutinaServicio;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    private final RutinaServicio rutinaServicio;

    public RutinaController(RutinaServicio rutinaServicio) {
        this.rutinaServicio = rutinaServicio;
    }

    @GetMapping
    public ResponseEntity<List<RutinaResponse>> listarRutinas() {
        return ResponseEntity.ok(rutinaServicio.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutinaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rutinaServicio.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RutinaResponse> crearRutina(@Valid @RequestBody RutinaRequest rutinaRequest) {
        RutinaResponse rutinaCreada = rutinaServicio.crear(rutinaRequest);
        return ResponseEntity.created(URI.create("/api/rutinas/" + rutinaCreada.getId())).body(rutinaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinaResponse> actualizar(@PathVariable Long id, @Valid @RequestBody RutinaRequest rutinaRequest) {
        return ResponseEntity.ok(rutinaServicio.actualizarRutina(id, rutinaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rutinaServicio.eliminarRutina(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{rutinaId}/clientes")
    public ResponseEntity<List<ClienteResponse>> listarClientesDeRutina(@PathVariable Long rutinaId) {
        return ResponseEntity.ok(rutinaServicio.listarClientesDeRutina(rutinaId));
    }
}
