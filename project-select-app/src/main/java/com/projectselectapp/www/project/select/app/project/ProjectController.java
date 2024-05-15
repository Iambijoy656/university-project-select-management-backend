package com.projectselectapp.www.project.select.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @CrossOrigin(origins = "*")
    @PostMapping("/create-project")
    @Transactional
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        try {
            System.out.println(project);
            project = projectRepository.save(project);
            return ResponseEntity.ok("Project Create Successfully"); // Return the saved project
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( e.getMessage());
        }

    }


}
