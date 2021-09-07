package com.example.thirdhomeworkyetanrikulu.repository;

import com.example.thirdhomeworkyetanrikulu.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {

    List<Student> findByNameContains(String name);

    @Query(value = "SELECT s.gender, count(s.gender) FROM Student s group by s.gender")
    List<?> groupByGender();

    @Transactional
    @Modifying
    @Query(value = "delete from Student s where s.name=:name")
    void deleteStudentByName(String name);

}
