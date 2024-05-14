package com.projectselectapp.www.project.select.app.notification;

import com.projectselectapp.www.project.select.app.student.Student;
import com.projectselectapp.www.project.select.app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping("/get-notification/{email}")
    @Transactional
    public void createNotification(@PathVariable("email") String email) {


    }







}
