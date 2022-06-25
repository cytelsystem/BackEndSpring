package com.dh.escuela.persistence.repository;

import com.dh.escuela.persistence.entity.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursadaRepository extends JpaRepository<Cursada, Long> {
}
