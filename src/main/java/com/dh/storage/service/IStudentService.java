package com.dh.storage.service;

import com.dh.storage.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<Student> findAllStudents();

    Optional<Student> findStudentById(Long id);

    Student saveStudent(Student studentNew);

    String deleteStudent(Long id);

    String updateStudent(Student StudentNew);
}
