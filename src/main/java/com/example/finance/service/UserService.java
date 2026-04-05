package com.example.finance.service;

import org.springframework.stereotype.Service;

import com.example.finance.entity.User;
import com.example.finance.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User updateStatus(Long id, String status) {
        User user = repo.findById(id).orElseThrow();
        user.setStatus(status);
        return repo.save(user);
    }
}