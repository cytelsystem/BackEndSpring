package com.dh.paqueteria.persistence.repository;

import com.dh.paqueteria.persistence.entity.Paquete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends MongoRepository<Paquete, Long> {

}
