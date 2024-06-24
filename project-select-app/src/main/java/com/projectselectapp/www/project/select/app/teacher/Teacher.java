package com.projectselectapp.www.project.select.app.teacher;

import com.projectselectapp.www.project.select.app.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String email;

    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(updatable = false)
    private Date createOn;

    @Column(insertable = false)
    private Date updateOn;


}
