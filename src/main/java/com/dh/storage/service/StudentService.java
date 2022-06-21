package com.dh.storage.service;

import com.dh.storage.repository.IStudentRepository;


public class StudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}

