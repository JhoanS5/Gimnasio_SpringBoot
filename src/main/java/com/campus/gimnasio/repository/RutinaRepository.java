package com.campus.gimnasio.repository;

import com.campus.gimnasio.entity.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RutinaRepository extends JpaRepository<Rutina, Long> {
    boolean existsByNombre(String nombre);
}
