package com.example.thirdhomeworkyetanrikulu.service;

import com.example.thirdhomeworkyetanrikulu.entity.Instructor;
import com.example.thirdhomeworkyetanrikulu.entity.PermanentInstructor;
import com.example.thirdhomeworkyetanrikulu.repository.InstructorRepository;
import com.example.thirdhomeworkyetanrikulu.repository.PermanentInstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final PermanentInstructorRepository permanentInstructorRepository;


    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        instructorRepository.findAll().forEach(instructorList::add);
        return instructorList;
    }

    public Instructor findById(int id) {
        return instructorRepository.findById(id).get();
    }

    public Instructor save(Instructor instructor) {
        return (Instructor) instructorRepository.save(instructor);
    }

    public Instructor update(Instructor instructor) {
        return save(instructor);
    }

    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }

    public void deleteByObject(Instructor instructor) {
        int id = instructor.getId();
        deleteById(id);
    }

    public List<Instructor> findIncludeName(String name) {
        return instructorRepository.findByNameContains(name);
    }

    public void deleteByName(String name) {
        instructorRepository.deleteInstructorByName(name);
    }

    public List<PermanentInstructor> findTop3AccordingToSalary() {

        Integer pageNo = 0;
        Integer pageSize = 3;
        String sortBy = "fixedSalary";
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        return permanentInstructorRepository.findTop3AccordingToSalary(paging);
    }

    public List<PermanentInstructor> findBottom3AccordingToSalary() {

        Integer pageNo = 0;
        Integer pageSize = 3;
        String sortBy = "fixedSalary";
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        return permanentInstructorRepository.findBottom3AccordingToSalary(paging);
    }
}

