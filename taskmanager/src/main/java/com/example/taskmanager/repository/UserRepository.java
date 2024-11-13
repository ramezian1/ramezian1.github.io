package com.example.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanager.model.AppUser;  // Make sure the correct path is used


public interface UserRepository extends JpaRepository<AppUser, Long> {
}
