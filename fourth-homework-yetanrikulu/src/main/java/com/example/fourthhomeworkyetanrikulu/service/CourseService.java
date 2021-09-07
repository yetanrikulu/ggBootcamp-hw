package com.example.fourthhomeworkyetanrikulu.service;

import com.example.fourthhomeworkyetanrikulu.dto.CourseDTO;
import com.example.fourthhomeworkyetanrikulu.dto.StudentDTO;
import com.example.fourthhomeworkyetanrikulu.entity.Course;
import com.example.fourthhomeworkyetanrikulu.entity.Student;
import com.example.fourthhomeworkyetanrikulu.exception.CourseIsAlreadyExistException;
import com.example.fourthhomeworkyetanrikulu.exception.StudentNumberForOneCourseExceededException;
import com.example.fourthhomeworkyetanrikulu.mapper.GlobalMapper;
import com.example.fourthhomeworkyetanrikulu.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final GlobalMapper globalMapper;

    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().forEach(courseList::add);
        return courseList;
    }

    public Course findById(long id) {
        return courseRepository.findById(id).get();
    }

    public Course save(CourseDTO courseDTO) {

        Course course = globalMapper.mapFromCourseDTOtoCourse(courseDTO);

        if (courseRepository.existsByCourseCode(course.getCourseCode())){
            throw new CourseIsAlreadyExistException();
        }
        return courseRepository.save(course);
    }

    public Course update(CourseDTO courseDTO) {
        Course course = globalMapper.mapFromCourseDTOtoCourse(courseDTO);
        return courseRepository.save(course);
    }

    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }

    public void deleteByObject(CourseDTO courseDTO) {
        long id = courseDTO.getId();
        deleteById(id);
    }

    public List<Course> findIncludeName(String name) {
        return courseRepository.findByCourseNameContains(name);
    }

    public void deleteByName(String name) {
        courseRepository.deleteCourseByCourseName(name);
    }

    public Course addStudentToCourse(StudentDTO studentDTO, long courseId){
        Course course = courseRepository.findById(courseId).get();

        List<Student> studentList = course.getStudentList();

        if(studentList.size()==20){
            throw new StudentNumberForOneCourseExceededException();
        }
        Student student = globalMapper.mapFromStudentDTOtoStudent(studentDTO);
        studentList.add(student);

        return courseRepository.save(course);



    }
}
