package com.dh.odontologica.persistence.repository;

import com.dh.odontologica.persistence.entity.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, Long> {
}
