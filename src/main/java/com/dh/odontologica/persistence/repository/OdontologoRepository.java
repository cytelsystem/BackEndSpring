package com.dh.odontologica.persistence.repository;

import com.dh.odontologica.persistence.entity.Domicilio;
import com.dh.odontologica.persistence.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
