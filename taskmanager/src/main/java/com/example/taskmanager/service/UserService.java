package com.example.taskmanager.service;

import com.example.taskmanager.model.AppUser;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }
}
