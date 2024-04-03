package com.projectselectapp.www.project.select.app.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Optional<Student> findByUserId(Integer userId);

    public List<Student> findByNameContaining(String name);
}
