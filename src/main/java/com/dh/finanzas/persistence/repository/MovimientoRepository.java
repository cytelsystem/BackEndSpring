package com.dh.finanzas.persistence.repository;

import com.dh.finanzas.persistence.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
