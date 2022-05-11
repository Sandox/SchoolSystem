package com.studentmanagment.demo.service;

import com.studentmanagment.demo.model.TestCreation;
import com.studentmanagment.demo.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCreationService {

    private final TestRepository testRepo;

    public TestCreationService(TestRepository repo){
        this.testRepo = repo;
    }

    public List<TestCreation> getListOfAllTest(){
        return testRepo.findAll();
    }

}
