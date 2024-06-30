package com.projectselectapp.www.project.select.app.admin;

import com.projectselectapp.www.project.select.app.teacher.Teacher;
import com.projectselectapp.www.project.select.app.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "admins")
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String email;
    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    @OneToOne
    @JoinColumn
    private Teacher supervisor;

    @Column(updatable = false)
    private Date createOn;

    @Column(insertable = false)
    private Date updateOn;


}
