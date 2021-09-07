package com.example.thirdhomeworkyetanrikulu.repository;

import com.example.thirdhomeworkyetanrikulu.entity.Course;
import com.example.thirdhomeworkyetanrikulu.entity.Instructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface InstructorRepository extends CrudRepository<Instructor,Integer> {

    List<Instructor> findByNameContains(String name);

    @Transactional
    @Modifying
    @Query(value = "delete from Instructor i where i.name=:name")
    void deleteInstructorByName(String name);




}
