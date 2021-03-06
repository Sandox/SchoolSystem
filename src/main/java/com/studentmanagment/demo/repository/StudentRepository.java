package com.studentmanagment.demo.repository;

import com.studentmanagment.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long id);

    Optional<Student> findStudentByStudentNumber(int studentNumber);

    Boolean existsByStudentNumber(int studentNumber);


}
