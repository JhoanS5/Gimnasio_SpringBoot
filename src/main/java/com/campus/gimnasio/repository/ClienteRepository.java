package com.campus.gimnasio.repository;

import com.campus.gimnasio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByDocumento(String documento);

    List<Cliente> findByRutinasId(Long rutinaId);
}
