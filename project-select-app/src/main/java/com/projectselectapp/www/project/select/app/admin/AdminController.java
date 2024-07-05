package com.projectselectapp.www.project.select.app.admin;


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
public class AdminController {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/create-admin")
    @Transactional
    public void createAdmin(@RequestBody User user) {
        user = userRepository.save(user);

        Admin admin = new Admin();
        admin.setName(user.getName());
        admin.setEmail(user.getEmail());
        admin.setUser(user);
        admin.setCreateOn(new Date());
        adminRepository.save(admin);



    }

    @GetMapping("/get-all-admin")
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }


    @GetMapping("get-admin/{id}")
    public Admin getAdminById(@PathVariable("id") Integer id) throws Exception {
        return adminRepository.findById(id).orElse(new Admin());
    }


    @GetMapping("get-admin-by-email/{email}")
    public Optional<Admin> getStudentByEmail(@PathVariable("email") String email) throws Exception {
        return Optional.ofNullable(adminRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Admin not found with email: " + email)));
    }


    @CrossOrigin(origins = "*")
    @PutMapping("/update-Admin")
    @Transactional
    public String updateAdmin(@RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new Exception("Id Not Found.. Please provide user Id");
        }
        User databaseUser = userRepository.findById(user.getId()).get();
        copyNonNullProperties(user, databaseUser);
        userRepository.save(databaseUser);

        Optional<Admin> optionalAdmin = adminRepository.findByUserId(user.getId());
        if (optionalAdmin.isEmpty()) {
            throw new Exception("No Admin found with this id");
        }

        Admin admin = optionalAdmin.get();
        admin.setName(user.getName());
        admin.setUpdateOn(new Date());
        adminRepository.save(admin);
        return "admin update Successfully";

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete-admin/{id}")
    @Transactional
    public String deleteAdmin(@PathVariable("id") Integer id) throws Exception {
        try {
            // Check if the ID is null
            if (id == null) {
                throw new Exception("ID Not Found. Please provide a user ID");
            }
            Optional<Admin> optionalAdmin = adminRepository.findById(id);
            if (optionalAdmin.isEmpty()) {
                throw new Exception("No Admin found with this ID");
            }
// Get the student
            Admin admin = optionalAdmin.get();

// Access the associated user's ID
            System.out.println(admin.getUser().getId());

            // Check if the user exists
            Optional<User> optionalUser = userRepository.findById(admin.getUser().getId());
            if (optionalUser.isEmpty()) {
                throw new Exception("No User found with this ID");
            }
            // Delete the student
            adminRepository.delete(admin);
            // Delete the user
            userRepository.delete(optionalUser.get());

            return "admin Deleted Successfully";
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
