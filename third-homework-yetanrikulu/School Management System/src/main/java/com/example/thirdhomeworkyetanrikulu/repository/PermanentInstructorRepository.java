package com.example.thirdhomeworkyetanrikulu.repository;

import com.example.thirdhomeworkyetanrikulu.entity.PermanentInstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermanentInstructorRepository extends CrudRepository<PermanentInstructor, Integer> {

    @Query(value = " select p from PermanentInstructor p order by p.fixedSalary desc")
    List<PermanentInstructor> findTop3AccordingToSalary(Pageable pageable);

    @Query(value = " select p from PermanentInstructor p order by p.fixedSalary ")
    List<PermanentInstructor> findBottom3AccordingToSalary(Pageable pageable);


}
