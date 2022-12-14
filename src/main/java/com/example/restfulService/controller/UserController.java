package com.example.restfulService.controller;

import com.example.restfulService.UserService;
import com.example.restfulService.domain.User;
import com.example.restfulService.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Long id){
        User user = userService.findById(id);

        if(user == null){
            throw new UserNotFoundException("ID[" + id + "] not found");
        }
        return user;

    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user){
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
