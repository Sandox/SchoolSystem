package com.studentmanagment.demo.service;

import com.studentmanagment.demo.exceptions.UserNotFoundException;
import com.studentmanagment.demo.model.TestCreation;
import com.studentmanagment.demo.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestCreationService {

    private final TestRepository testRepo;

    public TestCreationService(TestRepository repo){
        this.testRepo = repo;
    }

    public List<TestCreation> getListOfAllTest(){
        return testRepo.findAll();
    }

    public TestCreation createNewTest(TestCreation test){
        test.setTestCode((int) (Math.random() * 100000));
        Optional<TestCreation> testOptional = testRepo.findTestByTestCode(test.getTestCode());
        if(testOptional.isPresent()){
            throw new IllegalStateException("Test with code: " + test.getTestCode() + " is already Taken");
        }
        return testRepo.save(test);
    }

    public TestCreation findTestByTestCode(int testCode){
        return testRepo.findTestByTestCode(testCode).orElseThrow(() ->
        new IllegalStateException("Test with code: " +testCode + " doesnt exist"));
    }

    public TestCreation findTestById(long id){
        return testRepo.findTestById(id).orElseThrow(() ->
                new IllegalStateException("Test with id: " +id + " doesnt exist"));
    }

    public void deleteTestByTestCode(int testCode) {
        boolean testToBeDeleted = testRepo.existsByTestCode(testCode);
        if (!testToBeDeleted) {
            new IllegalStateException("Test with Test Code: " + testCode + " was not Found");
        }
    }

    public TestCreation findTestByTestCodeAndStudentNumber(int testCode, int studentNumber){
       return testRepo.findTestByTestCodeAndStudentNumber(testCode, studentNumber).orElseThrow(() ->
               new IllegalStateException("Test with Test Code: " + testCode + " was not Found"));
    }
}


