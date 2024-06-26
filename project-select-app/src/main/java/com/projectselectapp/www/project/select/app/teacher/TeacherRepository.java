package com.projectselectapp.www.project.select.app.teacher;

import com.projectselectapp.www.project.select.app.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    public Optional<Teacher> findByUserId(Integer userId);
    Optional<Teacher> findByEmail(String email);
    public List<Teacher> findByNameContaining(String name);

}
