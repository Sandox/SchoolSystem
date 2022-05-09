package com.studentmanagment.demo.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private String surname;
    private int studentNumber;
    private String grade;

    public Student() {

    }

    public Student(String name, String surname, int studentNumber, String grade) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
