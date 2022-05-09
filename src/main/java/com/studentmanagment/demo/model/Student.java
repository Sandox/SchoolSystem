package com.studentmanagment.demo.model;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;

@Entity
@Table(name="student")
public class Student {
    private long id;
    private String name;
    private String surname;
    private int studentNumber;

    public Student() {

    }

    public Student(long id, String name, String surname, int studentNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
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
}
