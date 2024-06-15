package com.projectselectapp.www.project.select.app.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByUserId(Integer userId);
    Optional<Student> findByEmail(String email);
    List<Student> findByNameContaining(String name);
}
