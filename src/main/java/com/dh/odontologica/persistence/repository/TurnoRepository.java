package com.dh.odontologica.persistence.repository;

import com.dh.odontologica.persistence.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Domicilio, Long> {
}
