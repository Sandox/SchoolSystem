package com.studentmanagment.demo.service;

import com.studentmanagment.demo.exceptions.UserNotFoundException;
import com.studentmanagment.demo.model.Student;
import com.studentmanagment.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository repo){
        this.studentRepository = repo;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student){
        student.setStudentNumber((int) (Math.random() * 10000)*100);
        Optional<Student> studentOptional = studentRepository.findStudentByStudentNumber(student.getStudentNumber());
        if(studentOptional.isPresent()){
            throw new UserNotFoundException("Student with Student Number: " + student.getStudentNumber() + " is already taken");
        }
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id){
        return studentRepository.findStudentById(id).orElseThrow(() ->
                new UserNotFoundException("Student with Student Number: " + id + " was not Found"));
    }

    public Student findStudentByStudentNumber(int studentNumber){
        return studentRepository.findStudentByStudentNumber(studentNumber).orElseThrow(() ->
                new UserNotFoundException("Student with Student Number: " + studentNumber+ " was not Found"));
    }

    public void deleteStudentByStudentNumber(int studentNumber){
        boolean studentExist = studentRepository.existsByStudentNumber(studentNumber);
        if(!studentExist){
            throw new UserNotFoundException("Student with Student Number: " + studentNumber+ " was not Found");
        }
    }
}
