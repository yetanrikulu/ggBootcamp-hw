package com.example.hw2.service;

import com.example.hw2.dao.StudentDAO;
import com.example.hw2.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    public Student findById(int id) {
        return (Student) studentDAO.findById(id);
    }

    public Student save(Student student) {
        return (Student) studentDAO.save(student);
    }

    public Student update(Student student) {
        return save(student);
    }

    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }

    public void deleteByObject(Student student) {
        int id = student.getId();
        deleteById(id);
    }
}
