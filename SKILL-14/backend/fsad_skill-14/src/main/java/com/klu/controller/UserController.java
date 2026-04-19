package com.klu.controller;

import com.klu.model.User;
import com.klu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") // allow React
public class UserController {

    @Autowired
    private UserService service;

    // ✅ Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // ✅ Login
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.login(user.getUsername(), user.getPassword());
    }

    // ✅ Get Profile
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }
}