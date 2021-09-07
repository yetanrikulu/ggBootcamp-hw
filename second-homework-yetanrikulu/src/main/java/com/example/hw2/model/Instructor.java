package com.example.hw2.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructor.class, name = "PermanentInstructor"),
        @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VisitingResearcher")
})
public abstract class Instructor extends Person {
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();

    public Instructor(String name, String address, String phoneNumber) {
        super(name, address);
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }


    @Override
    public String toString() {
        return "Instructor{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}

