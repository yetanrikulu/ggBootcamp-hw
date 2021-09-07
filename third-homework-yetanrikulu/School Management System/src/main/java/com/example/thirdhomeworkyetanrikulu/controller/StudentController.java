package com.example.thirdhomeworkyetanrikulu.controller;

import com.example.thirdhomeworkyetanrikulu.entity.Student;
import com.example.thirdhomeworkyetanrikulu.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @DeleteMapping
    public void deleteByObject(@RequestBody Student student) {
        studentService.deleteByObject(student);
    }

    @GetMapping("/nameInclude/{name}")
    public List<Student> findIncludeName(@PathVariable String name){
        return studentService.findIncludeName(name);
    }

    @GetMapping("/groupByGender")
    public List<?> groupByGender(){
        return studentService.groupByGender();
    }

    @DeleteMapping("/deleteByName/{name}")
    public void deleteByName(@PathVariable String name){
        studentService.deleteByName(name);
    }
}

