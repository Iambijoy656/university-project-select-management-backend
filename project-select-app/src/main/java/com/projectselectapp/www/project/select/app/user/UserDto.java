package com.projectselectapp.www.project.select.app.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data

public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String role;
    private String card_id;
    private boolean married_status;
    private Date dateOfBirth;

}

