package com.projectselectapp.www.project.select.app.student;

import com.projectselectapp.www.project.select.app.user.User;
import com.projectselectapp.www.project.select.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create-student")
    @Transactional
    public void createStudent(@RequestBody User user) {
        user = userRepository.save(user);

        Student student = new Student();
        student.setName(user.getName());
        student.setUser(user);
        student.setCreateOn(new Date());
        studentRepository.save(student);
    }

    @GetMapping("/get-all-student")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }


    @PutMapping("/update-student")
    @Transactional
    public String updateStudent(@RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new Exception("Id Not Found.. Please provide user Id");
        }
        userRepository.save(user);

        Optional<Student> optionalStudent = studentRepository.findByUserId(user.getId());
        if (optionalStudent.isEmpty()) {
            throw new Exception("No Student found with this id");
        }

        Student student = optionalStudent.get();
        student.setName(user.getName());
        student.setUpdateOn(new Date());
        studentRepository.save(student);
        return "Student Deleted Successfully";

    }


    @DeleteMapping("/delete-student/{id}")
    @Transactional
    public String deleteStudent(@PathVariable("id") Integer id) throws Exception {
        // Check if the ID is null
        if (id == null) {
            throw new Exception("ID Not Found. Please provide a user ID");
        }


        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new Exception("No Student found with this ID");
        }

// Get the student
        Student student = optionalStudent.get();

// Access the associated user's ID
        System.out.println(student.getUser().getId());

        // Check if the user exists
        Optional<User> optionalUser = userRepository.findById(student.getUser().getId());
        if (optionalUser.isEmpty()) {
            throw new Exception("No User found with this ID");
        }

        // Delete the user
        userRepository.deleteById(id);

        // Delete the student
        studentRepository.delete(student);

        return "Student Deleted Successfully";
    }


}