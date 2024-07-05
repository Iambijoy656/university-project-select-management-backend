package com.projectselectapp.www.project.select.app.Notification;


import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Nitification")

public class                 Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="Role")
    private String role;

    @Column(name ="User_info")
    private int userInfo;

    @Column(name ="Titel")
    private String titel;

    @Column(name ="sub_title")
    private String subTitle;

    @Column(name ="Type")
    private String type;

    @Column(name ="Link")
    private String link;

    @Column(name ="IsRead")
    private String isRead;

}
