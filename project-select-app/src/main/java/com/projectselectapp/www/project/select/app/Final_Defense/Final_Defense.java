package com.projectselectapp.www.project.select.app.Final_Defense;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Final_Defense")

public class Final_Defense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="Student_Id")
    private int studentId;

    @Column(name ="Project_Link")
    private String projectLink;

    @Column(name ="Report_Link")
    private String reportLink;
    @Column(name ="PPT_Link")
    private String pptLink;


}