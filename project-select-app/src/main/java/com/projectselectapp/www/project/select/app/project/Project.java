package com.projectselectapp.www.project.select.app.project;

import com.projectselectapp.www.project.select.app.teacher.Teacher;
import com.projectselectapp.www.project.select.app.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String student_id;
    @OneToOne
    @JoinColumn
    private User student_user_id;
    private String title;
    private String object;
    private String mythology;
    private String ppt;
    private String status;

    @ManyToOne
    @JoinColumn
    private Teacher supervisor1;
    @ManyToOne
    @JoinColumn
    private Teacher supervisor2;
    @ManyToOne
    @JoinColumn
    private Teacher supervisor3;
    @ManyToOne
    @JoinColumn
    private Teacher supervisor4;
    @ManyToOne
    @JoinColumn
    private Teacher supervisor5;


}
