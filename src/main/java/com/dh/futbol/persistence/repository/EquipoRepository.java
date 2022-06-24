package com.dh.futbol.persistence.repository;

import com.dh.futbol.model.EquipoDTO;
import com.dh.futbol.persistence.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
}
