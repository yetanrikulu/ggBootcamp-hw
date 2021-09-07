package com.example.thirdhomeworkyetanrikulu.controller;

import com.example.thirdhomeworkyetanrikulu.entity.Course;
import com.example.thirdhomeworkyetanrikulu.entity.Instructor;
import com.example.thirdhomeworkyetanrikulu.entity.PermanentInstructor;
import com.example.thirdhomeworkyetanrikulu.repository.PermanentInstructorRepository;
import com.example.thirdhomeworkyetanrikulu.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;
    private final PermanentInstructorRepository permanentInstructorRepository;

    @GetMapping
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Instructor> save(@RequestBody Instructor instructor){
        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Instructor> update(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.update(instructor), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        instructorService.deleteById(id);
    }

    @DeleteMapping
    public void deleteByObject(@RequestBody Instructor instructor){
        instructorService.deleteByObject(instructor);
    }

    @GetMapping("/nameInclude/{name}")
    public List<Instructor> findIncludeName(@PathVariable String name){
        return instructorService.findIncludeName(name);
    }

    @DeleteMapping("/deleteByName/{name}")
    public void deleteByName(@PathVariable String name){
        instructorService.deleteByName(name);
    }

    @GetMapping("/highestSalary")
    public ResponseEntity<List<PermanentInstructor>> getThreeInstructorHaveHighestSalary(){
        return new ResponseEntity<>(instructorService.findTop3AccordingToSalary(), HttpStatus.OK);
    }

    @GetMapping("/lowestSalary")
    public ResponseEntity<List<PermanentInstructor>> getThreeInstructorHaveLowestSalary(){
        return new ResponseEntity<>(instructorService.findBottom3AccordingToSalary(), HttpStatus.OK);
    }
}
