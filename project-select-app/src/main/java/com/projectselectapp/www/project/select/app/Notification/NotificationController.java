package com.projectselectapp.www.project.select.app.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @PostMapping
    public ResponseEntity<NotificationDto>createNotification(@RequestBody NotificationDto notificationDto){
        NotificationDto newNotificationDto = notificationService.createNotification(notificationDto);
        return new ResponseEntity<>(newNotificationDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAllNotification(){
        List<NotificationDto> newNotificationDto = notificationService.getAll();
        return ResponseEntity.ok(newNotificationDto);
    }

    @GetMapping("{id}")
    public  ResponseEntity<NotificationDto> getById(@PathVariable("id") Long id){
        NotificationDto notificationDto = notificationService.findById(id);
        return ResponseEntity.ok(notificationDto);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        notificationService.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping
    public ResponseEntity<NotificationDto> updateNotification(@RequestBody NotificationDto notificationDto){
        NotificationDto notification = notificationService.updateNotification(notificationDto);
        return  ResponseEntity.ok(notification);
    }


}
