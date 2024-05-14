package com.projectselectapp.www.project.select.app.notification;

import com.projectselectapp.www.project.select.app.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

}
