package com.projectselectapp.www.project.select.app.project;

import com.projectselectapp.www.project.select.app.teacher.Teacher;
import com.projectselectapp.www.project.select.app.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String student;
    private String title;
    private String object;
    private String mythology;
    private String ppt;
    private String status;
    @OneToOne
    @JoinColumn(nullable = false)
    private Teacher teacher;

}