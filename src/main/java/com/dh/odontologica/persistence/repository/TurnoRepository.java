package com.dh.odontologica.persistence.repository;

import com.dh.odontologica.persistence.entity.Turno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends MongoRepository<Turno, Long> {
}
