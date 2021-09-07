package com.example.fourthhomeworkyetanrikulu.controller;

import com.example.fourthhomeworkyetanrikulu.dto.InstructorDTO;
import com.example.fourthhomeworkyetanrikulu.entity.Instructor;
import com.example.fourthhomeworkyetanrikulu.service.InstructorService;
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

    @GetMapping
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Instructor> save(@RequestBody InstructorDTO instructorDTO) {
        return new ResponseEntity<>(instructorService.save(instructorDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Instructor> update(@RequestBody InstructorDTO instructorDTO) {
        return new ResponseEntity<>(instructorService.update(instructorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable long id) {
        instructorService.deleteById(id);
    }

    @DeleteMapping
    public void deleteByObject(@RequestBody InstructorDTO instructorDTO) {
        instructorService.deleteByObject(instructorDTO);
    }

    @GetMapping("/nameInclude/{name}")
    public List<Instructor> findIncludeName(@PathVariable String name) {
        return instructorService.findIncludeName(name);
    }

    @DeleteMapping("/deleteByName/{name}")
    public void deleteByName(@PathVariable String name) {
        instructorService.deleteByName(name);
    }

}

