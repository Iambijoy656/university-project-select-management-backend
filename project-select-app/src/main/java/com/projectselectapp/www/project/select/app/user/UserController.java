package com.projectselectapp.www.project.select.app.user;


import com.projectselectapp.www.project.select.app.student.Student;
import com.projectselectapp.www.project.select.app.student.StudentRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("get-all-user")
    public List<User> getAll(){
        return userRepository.findAll();
    }








}
