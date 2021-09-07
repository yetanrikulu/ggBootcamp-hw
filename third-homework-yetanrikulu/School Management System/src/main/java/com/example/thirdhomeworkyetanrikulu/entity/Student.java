package com.example.thirdhomeworkyetanrikulu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    private LocalDate birthDate;
    private String gender;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Course> courseList = new ArrayList<>();

    public Student(String name, String address, LocalDate birthDate,String gender){
        setName(name);
        setAddress(address);
        setBirthDate(birthDate);
        setGender(gender);
    }

}