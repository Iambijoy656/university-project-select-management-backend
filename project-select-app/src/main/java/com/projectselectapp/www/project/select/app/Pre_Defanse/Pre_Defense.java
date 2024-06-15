package com.projectselectapp.www.project.select.app.Pre_Defanse;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Pre_Defense")

public class Pre_Defense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="Student_Id")
    private int studentId;

    @Column(name ="Project_Link")
    private String projectLink;

    @Column(name ="Report_Link")
    private String reportLink;


}