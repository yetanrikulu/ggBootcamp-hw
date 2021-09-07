package com.example.hw2.dao;

import com.example.hw2.model.Instructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements InstructorDAO<Instructor> {

    private final EntityManager entityManager;

    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}
