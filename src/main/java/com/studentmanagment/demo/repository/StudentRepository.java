package com.studentmanagment.demo.repository;

import com.studentmanagment.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long id);

    Optional<Student> findStudentByStudentNumber(int studentNumber);

    void deleteStudentById(Long id);


}
