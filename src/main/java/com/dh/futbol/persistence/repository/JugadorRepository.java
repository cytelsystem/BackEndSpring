package com.dh.futbol.persistence.repository;

import com.dh.futbol.persistence.entity.Equipo;
import com.dh.futbol.persistence.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
}
