package com.projectselectapp.www.project.select.app.teacher;
import com.projectselectapp.www.project.select.app.student.Student;
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
public class TeacherController {
    @Autowired
   TeacherRepository teacherRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/create-teacher")
    @Transactional
    public void createTeacher(@RequestBody User user) {
        user = userRepository.save(user);

        Teacher teacher = new Teacher();
        teacher.setName(user.getName());
        teacher.setUser(user);
        teacher.setCreateOn(new Date());
        teacherRepository.save(teacher);
    }

    @GetMapping("/get-all-teacher")
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }


    @GetMapping("get-teacher/{id}")
    public Teacher getTeacherById(@PathVariable("id") Integer id) throws Exception {
        return teacherRepository.findById(id).orElse(new Teacher());
    }


    @CrossOrigin(origins = "*")
    @PutMapping("/update-teacher")
    @Transactional
    public String updateTeacher(@RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new Exception("Id Not Found.. Please provide user Id");
        }
        userRepository.save(user);

        Optional<Teacher> optionalTeacher = teacherRepository.findByUserId(user.getId());
        if (optionalTeacher.isEmpty()) {
            throw new Exception("No Teacher found with this id");
        }

        Teacher teacher = optionalTeacher.get();
        teacher.setName(user.getName());
        teacher.setUpdateOn(new Date());
        teacherRepository.save(teacher);
        return "Teacher Deleted Successfully";

    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete-teacher/{id}")
    @Transactional
    public String deleteTeacher(@PathVariable("id") Integer id) throws Exception {
        try {
            // Check if the ID is null
            if (id == null) {
                throw new Exception("ID Not Found. Please provide a user ID");
            }
            Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
            if (optionalTeacher.isEmpty()) {
                throw new Exception("No teacher found with this ID");
            }
// Get the student
            Teacher teacher = optionalTeacher.get();

// Access the associated user's ID
            System.out.println(teacher.getUser().getId());

            // Check if the user exists
            Optional<User> optionalUser = userRepository.findById(teacher.getUser().getId());
            if (optionalUser.isEmpty()) {
                throw new Exception("No User found with this ID");
            }
            // Delete the teacher
            teacherRepository.delete(teacher);
            // Delete the user
            userRepository.delete(optionalUser.get());

            return "teacher Deleted Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }






}
