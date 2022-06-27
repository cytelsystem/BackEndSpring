package com.dh.odontologica.persistence.repository;

import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.persistence.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
