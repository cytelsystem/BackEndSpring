package com.dh.storage.controller;


import com.dh.storage.entity.Student;
import com.dh.storage.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentServiceImpl studentService;


    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/json")
    public List<Student> getStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @PostMapping("/student/add")
    public Student addStudent(Student student){

        return studentService.saveStudent(student);

    }

    @DeleteMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/student/update")
    public String updateStudent(Student studentNew){
        return studentService.updateStudent(studentNew);
    }

}
