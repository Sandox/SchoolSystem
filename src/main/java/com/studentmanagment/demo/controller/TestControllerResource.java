package com.studentmanagment.demo.controller;

import com.studentmanagment.demo.model.TestCreation;
import com.studentmanagment.demo.service.TestCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/test")
public class TestControllerResource {

    private final TestCreationService testService;

    @Autowired
    public TestControllerResource(TestCreationService service){
        this.testService = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TestCreation>> getAllTests(){
        List<TestCreation> tests = testService.getListOfAllTest();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TestCreation> addNewTest(@RequestBody TestCreation test){
        TestCreation newTest = testService.createNewTest(test);
        return new ResponseEntity<>(newTest, HttpStatus.CREATED);
    }

    @GetMapping("/find/{testcode}")
    public ResponseEntity<TestCreation> findTestByTestCode(@PathVariable("testcode") int testCode){
        TestCreation selectedTest = testService.findTestByTestCode(testCode);
        return new ResponseEntity<>(selectedTest, HttpStatus.OK);
    }

    @GetMapping("/get/{testcode}/{studentnum}")
    public ResponseEntity<TestCreation> getTestByTestCodeAndStudentNumber(
            @PathVariable("testcode") int testCode,
            @PathVariable("studentnum") int studentNumber){
        TestCreation selectedTestByCodeAndStudentNum = testService.findTestByTestCodeAndStudentNumber(
                testCode,studentNumber );
        return new ResponseEntity<>(selectedTestByCodeAndStudentNum, HttpStatus.OK );
    }
}
