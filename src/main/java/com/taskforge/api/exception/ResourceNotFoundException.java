package com.taskforge.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNotFoundException.java
 * Purpose: Custom exception for 404 cases
 * - Used when Post/User not found
 * - @ResponseStatus makes Spring return 404 automatically
 */
@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Long id) {
        super("Post with ID " + id + " not found king 👑");
    }
}