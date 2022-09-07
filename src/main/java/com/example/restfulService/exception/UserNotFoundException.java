package com.example.restfulService.exception;

// HTTP Status code
// 2XX -> OK
// 4XX -> Client Problem
// 5XX -> Server Problem


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
