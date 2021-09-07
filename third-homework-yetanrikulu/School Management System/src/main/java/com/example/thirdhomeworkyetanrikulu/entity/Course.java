package com.example.thirdhomeworkyetanrikulu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private int creditScore;

    @ManyToOne (cascade = {CascadeType.ALL})
    @JsonIgnore
    private Instructor instructor;
    @ManyToMany (cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Student> studentList = new ArrayList<>();

    public Course(String courseName, String courseCode, int creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }
}