package com.projectselectapp.www.project.select.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectSelectAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSelectAppApplication.class, args);
		System.out.println("Project Running On port 8080...");
	}

}
