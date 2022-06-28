package com.dh.veterinaria.persistence.repository;

import com.dh.veterinaria.persistence.entity.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinariaRepository extends JpaRepository<Veterinaria, Long> {
}
