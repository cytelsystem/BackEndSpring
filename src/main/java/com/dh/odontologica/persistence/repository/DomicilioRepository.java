package com.dh.odontologica.persistence.repository;

import com.dh.odontologica.persistence.entity.Domicilio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends MongoRepository<Domicilio, Long> {
}
