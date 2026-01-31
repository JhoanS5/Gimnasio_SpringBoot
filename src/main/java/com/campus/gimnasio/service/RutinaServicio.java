package com.campus.gimnasio.service;

import com.campus.gimnasio.dto.ClienteResponse;
import com.campus.gimnasio.dto.RutinaRequest;
import com.campus.gimnasio.dto.RutinaResponse;
import com.campus.gimnasio.entity.Cliente;
import com.campus.gimnasio.entity.Rutina;
import com.campus.gimnasio.repository.ClienteRepository;
import com.campus.gimnasio.repository.RutinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaServicio {

    private final RutinaRepository rutinaRepository;
    private final ClienteRepository clienteRepository;

    public RutinaServicio(RutinaRepository rutinaRepository, ClienteRepository clienteRepository) {
        this.rutinaRepository = rutinaRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<RutinaResponse> listar() {
        return rutinaRepository.findAll().stream().map(this::convertirResponse).toList();
    }

    public RutinaResponse buscarPorId(Long id) {
        Rutina rutina = rutinaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la rutina con el id: " + id));
        return convertirResponse(rutina);
    }

    public RutinaResponse crear(RutinaRequest rutinaRequest) {
        boolean existeLaRutina = rutinaRepository.existsByNombre(rutinaRequest.getNombre());

        if (existeLaRutina) {
            throw new RuntimeException("El nombre de la rutina ingresada ya existe");
        }

        Rutina rutinaAGuardar = new Rutina(rutinaRequest.getNombre(), rutinaRequest.getNivel());
        return convertirResponse(rutinaRepository.save(rutinaAGuardar));
    }

    public RutinaResponse actualizarRutina(Long id, RutinaRequest rutinaRequest) {
        Rutina rutinaExistente = rutinaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la rutina con el id: " + id));

        if (!rutinaExistente.getNombre().equals(rutinaRequest.getNombre()) && rutinaRepository.existsByNombre(rutinaRequest.getNombre())) {
            throw new RuntimeException("El nombre de la rutina ya pertenece a otra");
        }

        rutinaExistente.setNombre(rutinaRequest.getNombre());
        rutinaExistente.setNivel(rutinaRequest.getNivel());

        return convertirResponse(rutinaRepository.save(rutinaExistente));
    }

    public void eliminarRutina(Long id) {
        if (rutinaRepository.existsById(id)) {
            rutinaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Rutina no encontrada con el id " + id);
        }
    }

    public List<ClienteResponse> listarClientesDeRutina(Long rutinaId) {
        if (!rutinaRepository.existsById(rutinaId)) {
            throw new RuntimeException("Rutina no encontrada");
        }

        return clienteRepository.findByRutinasId(rutinaId).stream()
                .map(cliente -> new ClienteResponse(cliente.getId(), cliente.getNombre(), cliente.getDocumento(), cliente.getActivo()))
                .toList();
    }

    private RutinaResponse convertirResponse(Rutina rutina) {
        return new RutinaResponse(rutina.getId(), rutina.getNombre(), rutina.getNivel());
    }
}
