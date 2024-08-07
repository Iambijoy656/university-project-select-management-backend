package com.projectselectapp.www.project.select.app.student;

import com.projectselectapp.www.project.select.app.teacher.Teacher;
import com.projectselectapp.www.project.select.app.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String marks;
    private String followup;
    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn
    private Teacher supervisor;

    @Column(updatable = false)
    private Date createOn;

    @Column(insertable = false)
    private Date updateOn;


}
