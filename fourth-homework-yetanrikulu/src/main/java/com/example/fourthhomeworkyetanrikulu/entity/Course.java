package com.example.fourthhomeworkyetanrikulu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course extends AbstractBaseEntity {

    private String courseName;
    private String courseCode;
    private int creditScore;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JsonIgnore
    private Instructor instructor;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Student> studentList = new ArrayList<>();

    public Course(String courseName, String courseCode, int creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }
}
