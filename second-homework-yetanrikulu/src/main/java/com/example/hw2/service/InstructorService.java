package com.example.hw2.service;

import com.example.hw2.dao.InstructorDAO;
import com.example.hw2.model.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorDAO instructorDAO;

    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    public Instructor findById(int id) {
        return (Instructor) instructorDAO.findById(id);
    }

    public Instructor save(Instructor instructor) {
        return (Instructor) instructorDAO.save(instructor);
    }

    public Instructor update(Instructor instructor) {
        return save(instructor);
    }

    public void deleteById(int id) {
        instructorDAO.deleteById(id);
    }

    public void deleteByObject(Instructor instructor) {
        int id = instructor.getId();
        deleteById(id);
    }
}
