package com.projectselectapp.www.project.select.app.project;

import com.projectselectapp.www.project.select.app.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository  extends JpaRepository<Project , Integer> {

}
