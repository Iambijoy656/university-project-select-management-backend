package com.projectselectapp.www.project.select.app.user;


import com.projectselectapp.www.project.select.app.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;
    @GetMapping("get-all-user")
    public List<User> getAll() {
        return userRepository.findAll();
    }




    @PostMapping("/login")
    public Object login(@RequestBody LoginDto user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent() && optionalUser.get().getPassword().equals(user.getPassword())){
            Map<String, String> userDetails = new HashMap<>();
            userDetails.put("email", optionalUser.get().getEmail());
            userDetails.put("name", optionalUser.get().getName());
            userDetails.put("role", optionalUser.get().getRole());
            userDetails.put("id", String.valueOf(optionalUser.get().getId()));
            return ResponseEntity.ok().body(userDetails);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    }


}
