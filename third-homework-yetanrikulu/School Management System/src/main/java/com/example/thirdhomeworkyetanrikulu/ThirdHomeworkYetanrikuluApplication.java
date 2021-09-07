package com.example.thirdhomeworkyetanrikulu;

import com.example.thirdhomeworkyetanrikulu.entity.*;
import com.example.thirdhomeworkyetanrikulu.service.CourseService;
import com.example.thirdhomeworkyetanrikulu.service.InstructorService;
import com.example.thirdhomeworkyetanrikulu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class ThirdHomeworkYetanrikuluApplication implements CommandLineRunner {


    @Autowired
    private CourseService courseService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(ThirdHomeworkYetanrikuluApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public void run(String... args) throws Exception {


        Course course = new Course("Matematik", "Mat101", 5);
        Course course2 = new Course("Fizik", "Phy101", 4);
        Course course3 = new Course("Kimya", "Chm101", 3);

        Instructor visitingResearcher = new VisitingResearcher("Veli Ziyaretçi", "Veli adres", "05555526454", 34.55);
        Instructor permanentIntructor = new PermanentInstructor("Ahmet Kalıcı", "Ahmet adres", "05553168596", 4567.89);

        Student student = new Student("Kemal Öğrenci", "Kemal Adres", LocalDate.of(2010, Month.JANUARY, 1), "Male");
        Student student2 = new Student("Zeynep Öğrenci", "Zeynep Adres", LocalDate.of(2009, Month.MARCH, 23), "Female");
        Student student3 = new Student("Ayşe Öğrenci", "Ayşe Adres", LocalDate.of(2011, Month.APRIL, 19), "Female");

        course.getStudentList().addAll(Arrays.asList(student, student2));
        course2.getStudentList().addAll(Arrays.asList(student2, student3));
        course3.getStudentList().addAll(Arrays.asList(student, student2, student3));

        course.setInstructor(visitingResearcher);
        course2.setInstructor(permanentIntructor);
        course3.setInstructor(permanentIntructor);

        permanentIntructor.getCourseList().addAll(Arrays.asList(course2, course3));
        visitingResearcher.getCourseList().add(course);

        student.getCourseList().addAll(Arrays.asList(course, course3));
        student2.getCourseList().addAll(Arrays.asList(course, course2, course3));
        student3.getCourseList().addAll(Arrays.asList(course2, course3));

        courseService.save(course);
        courseService.save(course2);
        courseService.save(course3);

        studentService.save(student);
        studentService.save(student2);
        studentService.save(student3);

        instructorService.save(permanentIntructor);
        instructorService.save(visitingResearcher);

    }
}
