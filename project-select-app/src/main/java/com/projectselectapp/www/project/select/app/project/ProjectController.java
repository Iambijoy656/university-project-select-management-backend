package com.projectselectapp.www.project.select.app.project;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @CrossOrigin(origins = "*")
    @PostMapping("/create-project")
    @Transactional
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        try {
            project = projectRepository.save(project);
            return ResponseEntity.ok("Project Create Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( e.getMessage());
        }

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-all-projects")
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update-project")
    @Transactional
    public ResponseEntity<String> updateProject(@RequestBody Project project) {
        try {
            if (project.getId() == null) {
            throw new Exception("Id Not Found.. Please provide project Id");
        }
        Project databaseProject = projectRepository.findById(project.getId()).get();
        copyNonNullProperties(project, databaseProject);
        projectRepository.save(databaseProject);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( e.getMessage());
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
