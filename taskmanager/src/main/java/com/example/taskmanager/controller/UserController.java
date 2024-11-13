package com.example.taskmanager.controller;

import com.example.taskmanager.model.AppUser;
import com.example.taskmanager.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService; // Instance variable

    // Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;  // Assign the injected service
    }

    // Endpoint to get all users
    @GetMapping
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();  // Calling on the instance of UserService
    }

    // Endpoint to create a user
    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return userService.saveUser(user);  // Calling on the instance of UserService
    }
}
