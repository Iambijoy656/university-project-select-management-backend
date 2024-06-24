package com.projectselectapp.www.project.select.app.teacher;
import com.projectselectapp.www.project.select.app.student.Student;
import com.projectselectapp.www.project.select.app.user.User;
import com.projectselectapp.www.project.select.app.user.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        teacher.setEmail(user.getEmail());
        teacher.setUser(user);
        teacher.setCreateOn(new Date());
        teacherRepository.save(teacher);
    }

    @GetMapping("/get-all-teacher")
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }



    @GetMapping("get-teacher-by-email/{email}")
    public Optional<Teacher> getTeacherByEmail(@PathVariable("email") String email) throws Exception {
        return Optional.ofNullable(teacherRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Teacher not found with email: " + email)));
    }
    @GetMapping("get-teacher/{id}")
    public Teacher getTeacherById(@PathVariable("id") Integer id) throws Exception {
        return teacherRepository.findById(id).orElse(new Teacher());
    }



    @CrossOrigin(origins = "*")
    @PutMapping("/update-teacher")
    @Transactional
    public String updateStudent(@RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new Exception("Id Not Found.. Please provide user Id");
        }
        User databaseUser = userRepository.findById(user.getId()).get();
        copyNonNullProperties(user, databaseUser);
        userRepository.save(databaseUser);

        Optional<Teacher> optionalTeacher = teacherRepository.findByUserId(user.getId());
        if (optionalTeacher.isEmpty()) {
            throw new Exception("No Teacher found with this id");
        }

        Teacher teacher = optionalTeacher.get();
        teacher.setName(user.getName());
        teacher.setUpdateOn(new Date());
        teacherRepository.save(teacher);
        return "Teacher update Successfully";

    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete-teacher/{id}")
    @Transactional
    public String deleteStudent(@PathVariable("id") Integer id) throws Exception {
        try {
            // Check if the ID is null
            if (id == null) {
                throw new Exception("ID Not Found. Please provide a user ID");
            }
            Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
            if (optionalTeacher.isEmpty()) {
                throw new Exception("No Teacher found with this ID");
            }
// Get the teacher
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

            return "Teacher Deleted Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }





    public void copyNonNullProperties(Object source, Object destination) {
        BeanUtils.copyProperties(source, destination, getNullPropertyNames(source));
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


}
