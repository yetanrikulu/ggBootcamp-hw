package com.example.hw2.dao;

import com.example.hw2.model.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {

    private final EntityManager entityManager;

    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}
