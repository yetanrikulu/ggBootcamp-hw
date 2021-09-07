package com.example.thirdhomeworkyetanrikulu.controller;

import com.example.thirdhomeworkyetanrikulu.entity.Course;
import com.example.thirdhomeworkyetanrikulu.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

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

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        courseService.deleteById(id);
    }

    @DeleteMapping
    public void deleteByObject(@RequestBody Course course) {
        courseService.deleteByObject(course);
    }

    @GetMapping("/nameInclude/{name}")
    public List<Course> findIncludeName(@PathVariable String name){
        return courseService.findIncludeName(name);
    }

    @DeleteMapping("/deleteByName/{name}")
    public void deleteByName(@PathVariable String name){
        courseService.deleteByName(name);
    }

}
