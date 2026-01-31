package com.campus.gimnasio.service;

import com.campus.gimnasio.dto.ClienteRequest;
import com.campus.gimnasio.dto.ClienteResponse;
import com.campus.gimnasio.dto.RutinaResponse;
import com.campus.gimnasio.entity.Cliente;
import com.campus.gimnasio.entity.Rutina;
import com.campus.gimnasio.repository.ClienteRepository;
import com.campus.gimnasio.repository.RutinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    private final ClienteRepository clienteRepository;
    private final RutinaRepository rutinaRepository;

    public ClienteServicio(ClienteRepository clienteRepository, RutinaRepository rutinaRepository) {
        this.clienteRepository = clienteRepository;
        this.rutinaRepository = rutinaRepository;
    }

    public List<ClienteResponse> listar() {
        return clienteRepository.findAll().stream().map(this::convertirResponse).toList();
    }

    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro al cliente con el id:" + id));
        return convertirResponse(cliente);
    }

    public ClienteResponse crear(ClienteRequest clienteRequest) {
        boolean existeElCliente = clienteRepository.existsByDocumento(clienteRequest.getDocumento());

        if (existeElCliente) {
            throw new RuntimeException("El documento ingresado ya existe.");
        }

        Cliente clienteAGuardar = new Cliente(clienteRequest.getNombre(), clienteRequest.getDocumento(), clienteRequest.getActivo());
        return convertirResponse(clienteRepository.save(clienteAGuardar));
    }

    public ClienteResponse actualizarCliente(Long id, ClienteRequest clienteRequest) {
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro al cliente con el id: " + id));

        if (!clienteExistente.getDocumento().equals(clienteRequest.getDocumento()) && clienteRepository.existsByDocumento(clienteRequest.getDocumento())) {
            throw new RuntimeException("El documento ingresado ya pertenece a otro cliente ");
        }

        clienteExistente.setNombre(clienteRequest.getNombre());
        clienteExistente.setDocumento(clienteRequest.getDocumento());
        clienteExistente.setActivo(clienteRequest.getActivo());

        return convertirResponse(clienteRepository.save(clienteExistente));
    }

    public void eliminarCliente(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }else {
            throw new RuntimeException("Cliente no encontrado con el id " + id);
        }
    }

    public void asignarRutina(Long clienteId, Long rutinaId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Rutina rutina = rutinaRepository.findById(rutinaId).orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        if (!cliente.getRutinas().contains(rutina)) {
            cliente.getRutinas().add(rutina);
            clienteRepository.save(cliente);
        }
    }

    public void quitarRutina(Long clienteId, Long rutinaId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        cliente.getRutinas().removeIf(rutina -> rutina.getId().equals(rutinaId));
        clienteRepository.save(cliente);
    }

    public List<RutinaResponse> listarRutinasDeCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return cliente.getRutinas().stream()
                .map(rutina -> new RutinaResponse(rutina.getId(), rutina.getNombre(), rutina.getNivel()))
                .toList();
    }


    private ClienteResponse convertirResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNombre(), cliente.getDocumento(), cliente.getActivo());
    }
}
