package com.studentmanagment.demo.repository;

import com.studentmanagment.demo.model.Student;
import com.studentmanagment.demo.model.TestCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestCreation, Long> {

    Optional<TestCreation> findTestById(Long id);

    Optional<TestCreation> findTestByTestCode(int testCode);
}
