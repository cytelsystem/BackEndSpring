package com.dh.futbol.persistence.repository;

import com.dh.futbol.model.EquipoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<EquipoDTO, Integer> {
}
