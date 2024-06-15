package com.projectselectapp.www.project.select.app.Final_Defense;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Final_DefenseDto {

    private long id;
    private int studentId;

    private String projectLink;

    private String reportLink;

    private String pptLink;

}