package com.projectselectapp.www.project.select.app.Notification;


public class Notificationmapper {

    public  static  Notification maptoNotification(NotificationDto notificationDto){

        return new Notification(
                notificationDto.getId(),
                notificationDto.getRole(),
                notificationDto.getUserInfo(),
                notificationDto.getTitel(),
                notificationDto.getSubTitle(),
                notificationDto.getType(),
                notificationDto.getLink(),
                notificationDto.getIsRead()
        );

    }
    public  static  NotificationDto maptoNotificationDto (Notification notification){
        return new NotificationDto(
                notification.getId(),
                notification.getRole(),
                notification.getUserInfo(),
                notification.getTitel(),
                notification.getSubTitle(),
                notification.getType(),
                notification.getLink(),
                notification.getIsRead()
        );
    }

}
