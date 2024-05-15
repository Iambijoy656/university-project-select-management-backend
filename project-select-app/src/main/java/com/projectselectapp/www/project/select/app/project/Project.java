package com.projectselectapp.www.project.select.app.project;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String student_id;
    private String title;
    private String object;
    private String mythology;
    private String ppt;
    private String status;
    private String supervisor1;
    private String supervisor2;
    private String supervisor3;
    private String supervisor4;
    private String supervisor5;

}
