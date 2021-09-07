package com.example.fourthhomeworkyetanrikulu.mapper;

import com.example.fourthhomeworkyetanrikulu.dto.CourseDTO;
import com.example.fourthhomeworkyetanrikulu.dto.InstructorDTO;
import com.example.fourthhomeworkyetanrikulu.dto.StudentDTO;
import com.example.fourthhomeworkyetanrikulu.entity.*;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

@Mapper
public interface GlobalMapper {

    Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);

    Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);


    @InheritConfiguration(name = "Instructor")
    PermanentInstructor mapToPermanent(InstructorDTO instructorDTO);

    @InheritConfiguration(name = "Instructor")
    VisitingResearcher mapToVisiting(InstructorDTO instructorDTO);


}
