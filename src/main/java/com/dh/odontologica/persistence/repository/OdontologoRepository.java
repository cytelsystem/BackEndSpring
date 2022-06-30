package com.dh.odontologica.persistence.repository;

import com.dh.odontologica.persistence.entity.Odontologo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends MongoRepository<Odontologo, Long> {
}
