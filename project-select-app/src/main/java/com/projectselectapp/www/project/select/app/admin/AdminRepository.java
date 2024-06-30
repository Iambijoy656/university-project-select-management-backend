package com.projectselectapp.www.project.select.app.admin;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUserId(Integer userId);
    Optional<Admin> findByEmail(String email);
    List<Admin> findByNameContaining(String name);
}
