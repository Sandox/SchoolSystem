package com.studentmanagment.demo.controller;

import com.studentmanagment.demo.model.Student;
import com.studentmanagment.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService service) {
        this.studentService = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student){
        Student newStudent = studentService.addNewStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("id") long id){
        Student selectedUser = studentService.findStudentById(id);
        return new ResponseEntity<>(selectedUser, HttpStatus.OK );
    }

    @GetMapping("/get/{studnumber}")
    public ResponseEntity<Student> findStudentById(@PathVariable("studnumber") int studnumber){
        Student selectedStudentNumber = studentService.findStudentByStudentNumber(studnumber);
        return new ResponseEntity<>(selectedStudentNumber, HttpStatus.OK );
    }

    @DeleteMapping("/delete/{studnumber}")
    public ResponseEntity<?> deleteStudentByStudentNumber(
            @PathVariable("studnumber") int studnumber){
       studentService.deleteStudentByStudentNumber(studnumber);
       return new ResponseEntity<>(HttpStatus.OK);
    }


}
