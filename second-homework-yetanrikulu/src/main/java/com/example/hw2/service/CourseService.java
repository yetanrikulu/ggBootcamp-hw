package com.example.hw2.service;

import com.example.hw2.dao.CourseDAO;
import com.example.hw2.dao.CourseDAOJPAImpl;
import com.example.hw2.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    public CourseService(CourseDAOJPAImpl courseDAOJPA) {
        this.courseDAO = courseDAOJPA;
    }

    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    public Course save(Course course) {
        return (Course) courseDAO.save(course);
    }

    public Course update(Course course) {
        return save(course);
    }

    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }

    public void deleteByObject(Course course) {
        int id = course.getId();
        deleteById(id);
    }
}
