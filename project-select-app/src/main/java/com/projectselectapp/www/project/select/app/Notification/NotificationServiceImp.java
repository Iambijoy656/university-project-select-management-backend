package com.projectselectapp.www.project.select.app.Notification;


import com.projectselectapp.www.project.select.app.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImp implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        Notification notification= Notificationmapper .maptoNotification(notificationDto);
        Notification saveNotification = notificationRepository.save(notification);
        NotificationDto newNotificationDto = Notificationmapper.maptoNotificationDto(saveNotification);
        return  newNotificationDto;
    }

    @Override
    public List<NotificationDto> getAll() {
        List<Notification> allNotification = notificationRepository.findAll();
        return allNotification.stream().map((notification) -> {
            return Notificationmapper.maptoNotificationDto(notification);
        }).collect(Collectors.toList());

    }

    @Override
    public NotificationDto findById(Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Exist with this id"+id));
        return Notificationmapper.maptoNotificationDto(notification);
    }

    @Override
    public void deleteById(Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Exist with this id"+id));
        notificationRepository.deleteById(id);


    }

    @Override
    public NotificationDto updateNotification(NotificationDto notificationDto) {
        Notification notification = notificationRepository.findById(notificationDto.getId()).orElseThrow(() -> new ResourceNotFoundException
                (" Update Notification is not exist with this id " + notificationDto.getId()));

        notification.setId(notificationDto.getId());
        notification.setRole(notificationDto.getRole());
        notification.setUserInfo(notificationDto.getUserInfo());
        notification.setType(notificationDto.getType());
        notification.setLink(notificationDto.getLink());
        notification.setTitel(notificationDto.getTitel());
        notification.setSubTitle(notificationDto.getSubTitle());
        notification.setIsRead(notificationDto.getIsRead());


        Notification saveNotification =notificationRepository.save(notification);
        return Notificationmapper.maptoNotificationDto(saveNotification);
    }
}