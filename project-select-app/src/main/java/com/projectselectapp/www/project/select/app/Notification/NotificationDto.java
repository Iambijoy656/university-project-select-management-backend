package com.projectselectapp.www.project.select.app.Notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NotificationDto {
    private long id;
    private String role;
    private int userInfo;
    private String titel;
    private String subTitle;
    private String type;
    private String link;
    private String isRead;


}