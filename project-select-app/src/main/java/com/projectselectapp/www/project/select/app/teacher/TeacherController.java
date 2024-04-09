package com.projectselectapp.www.project.select.app.teacher;

import com.projectselectapp.www.project.select.app.student.StudentRepository;
import com.projectselectapp.www.project.select.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TeacherController {
    @Autowired
   TeacherRepository teacherRepository;

    @Autowired
    UserRepository userRepository;
}
