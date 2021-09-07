package com.example.hw2.controller;

import com.example.hw2.model.Course;
import com.example.hw2.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Course> update(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.update(course), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        courseService.deleteById(id);
    }

    @DeleteMapping
    public void deleteByObject(@RequestBody Course course) {
        courseService.deleteByObject(course);
    }

}
