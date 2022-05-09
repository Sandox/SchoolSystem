package com.studentmanagment.demo.service;

import com.studentmanagment.demo.model.Student;
import com.studentmanagment.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository repo){
        this.studentRepository = repo;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

}
