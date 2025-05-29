package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User save(User user) {
        return repo.save(user);
    }

    public Optional<User> get(Long id) {
        return repo.findById(id);
    }
}