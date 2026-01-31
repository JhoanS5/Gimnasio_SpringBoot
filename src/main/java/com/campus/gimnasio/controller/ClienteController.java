package com.campus.gimnasio.controller;

import com.campus.gimnasio.dto.ClienteRequest;
import com.campus.gimnasio.dto.ClienteResponse;
import com.campus.gimnasio.dto.RutinaResponse;
import com.campus.gimnasio.service.ClienteServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteServicio clienteServicio;

    public ClienteController(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarClientes() {
        return ResponseEntity.ok(clienteServicio.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteServicio.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteCreado = clienteServicio.crear(clienteRequest);
        return ResponseEntity.created(URI.create("/api/clientes/" + clienteCreado.getId())).body(clienteCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity.ok(clienteServicio.actualizarCliente(id, clienteRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{clienteId}/rutinas/{rutinaId}")
    public ResponseEntity<Void> asignarRutina(@PathVariable Long clienteId, @PathVariable Long rutinaId) {
        clienteServicio.asignarRutina(clienteId, rutinaId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{clienteId}/rutinas/{rutinaId}")
    public ResponseEntity<Void> quitarRutina(@PathVariable Long clienteId, @PathVariable Long rutinaId) {
        clienteServicio.quitarRutina(clienteId, rutinaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{clienteId}/rutinas")
    public ResponseEntity<List<RutinaResponse>> listarRutinasDeCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(clienteServicio.listarRutinasDeCliente(clienteId));
    }
}
