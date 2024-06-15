package com.projectselectapp.www.project.select.app.student;

import com.projectselectapp.www.project.select.app.user.User;
import com.projectselectapp.www.project.select.app.user.UserDto;
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
        student.setEmail(user.getEmail());
        student.setUser(user);
        student.setCreateOn(new Date());
        studentRepository.save(student);
    }

    @GetMapping("/get-all-student")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }


    @GetMapping("get-student/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) throws Exception {
        return studentRepository.findById(id).orElse(new Student());
    }


    @GetMapping("get-student-by-email/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable("email") String email) throws Exception {
        return Optional.ofNullable(studentRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Student not found with email: " + email)));
    }


    @CrossOrigin(origins = "*")
    @PutMapping("/update-student")
    @Transactional
    public String updateStudent(@RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new Exception("Id Not Found.. Please provide user Id");
        }
        User databaseUser = userRepository.findById(user.getId()).get();
        copyNonNullProperties(user, databaseUser);
        userRepository.save(databaseUser);

        Optional<Student> optionalStudent = studentRepository.findByUserId(user.getId());
        if (optionalStudent.isEmpty()) {
            throw new Exception("No Student found with this id");
        }

        Student student = optionalStudent.get();
        student.setName(user.getName());
        student.setSupervisor(user.getSupervisor());
        student.setUpdateOn(new Date());
        studentRepository.save(student);
        return "Student update Successfully";

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete-student/{id}")
    @Transactional
    public String deleteStudent(@PathVariable("id") Integer id) throws Exception {
        try {
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
            // Delete the student
            studentRepository.delete(student);
            // Delete the user
            userRepository.delete(optionalUser.get());

            return "Student Deleted Successfully";
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