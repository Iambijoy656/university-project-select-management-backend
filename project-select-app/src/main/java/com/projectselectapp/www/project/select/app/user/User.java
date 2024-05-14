package com.projectselectapp.www.project.select.app.user;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String bio;
    private String email;
    private String password;
    private String gender;
    private String role;
    private String card_id;
    private boolean married_status;
    private Date dateOfBirth;

}

