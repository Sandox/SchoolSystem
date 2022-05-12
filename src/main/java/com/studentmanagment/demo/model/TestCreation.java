package com.studentmanagment.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Test")
public class TestCreation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private int testCode;
    private final String schoolName = "PPE Private School";
    private String teacherName;
    private int studentNumber;
    private String subject;
    private String question;
    private String answer;
    @Transient
    private boolean isCorrect;

    public TestCreation(){
    }

    public TestCreation(int testCode, String teacherName, int studentNumber,
                        String subject, int testTotal, String question, String answer) {
        this.testCode = testCode;
        this.teacherName = teacherName;
        this.studentNumber = studentNumber;
        this.subject = subject;
        this.question = question;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTestCode() {
        return testCode;
    }

    public void setTestCode(int testCode) {
        this.testCode = testCode;
    }

//    public void setSchoolName(){
//        this.schoolName = "PPE Private Schoool";
//    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect(String questionAnswer) {
        if(questionAnswer.equals(answer)){
            isCorrect = true;
        }
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
