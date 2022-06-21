package com.dh.storage.service;

import com.dh.storage.entity.Student;
import com.dh.storage.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{

    private final IStudentRepository studentRepository;


    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return IStudentRepository.findById(id);
    }


//    @Override
//    public Optional<Student> findStudentById(Long id) {
//        return IStudentRepository.findById(id);
//    }

    @Override
    public Student saveStudent(Student studentNew) {

        if (studentNew != null){
            return IStudentRepository.save(studentNew);
        }

        return new Student();

    }
    @Override
    public String deleteStudent(Long id) {

        if (IStudentRepository.findById(id).isPresent()){
            IStudentRepository.deleteById(id);
            return "Student with id " + id + " delete";
        }

        return "Student with id " + id + " dont exist";
    }
    @Override
    public String updateStudent(Student studentNew) {
        return null;
    }
}
