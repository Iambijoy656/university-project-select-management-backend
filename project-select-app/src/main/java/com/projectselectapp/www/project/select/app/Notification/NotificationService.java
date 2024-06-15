package com.projectselectapp.www.project.select.app.Notification;


import java.util.List;

public interface NotificationService  {

    NotificationDto createNotification(NotificationDto notificationDto);

    List<NotificationDto> getAll();

    NotificationDto findById(Long id);

    void deleteById(Long id);

    NotificationDto updateNotification (NotificationDto notificationDto);
}