package com.klu.service;

import com.klu.model.User;
import com.klu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public User login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }
}