package com.projectselectapp.www.project.select.app.user;

import com.projectselectapp.www.project.select.app.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Integer> {

}

