package com.dh.storage.repository;

import com.dh.storage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
