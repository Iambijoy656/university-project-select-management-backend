package com.projectselectapp.www.project.select.app.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class ResponseData<T> {
    private int statusCode;
    private boolean success;
    private String message;
    private T data;

    public ResponseData(int statusCode, boolean success, String message, T data) {
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Getters and setters
}
