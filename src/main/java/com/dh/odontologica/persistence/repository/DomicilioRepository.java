package com.dh.odontologica.persistence.repository;

import com.dh.odontologica.persistence.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long>{
}
