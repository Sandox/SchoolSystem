package com.studentmanagment.demo.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

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
    @Column(name = "date_of_birth")
    private LocalDate dob;
    @Transient
    private int age;
    private String gender;
    @Column(name = "ethnicity")
    private String race;

    public Student() {

    }

    public Student(String name, String surname, int studentNumber, LocalDate dateOfBirth,
                   String gender, String ethnicity) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.dob = dateOfBirth;
        this.gender = gender;
        this.race = ethnicity;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    //Calculate Student age using the date of birth
    public int getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Student: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", Gender='" + gender + '\'' +
                ", dateOfBirth=" + dob +
                ", age=" + age +
                ", Ethnicity=" + race +
                '}';
    }
}
