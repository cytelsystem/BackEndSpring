package com.dh.finanzas.persistence.repository;

import com.dh.finanzas.persistence.entities.Movimiento;
import com.dh.finanzas.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
