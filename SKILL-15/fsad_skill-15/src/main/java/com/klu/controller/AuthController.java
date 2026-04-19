package com.klu.controller;



import com.klu.entity.User;
import com.klu.repository.UserRepository;
import com.klu.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> dbUser = repo.findByUsername(user.getUsername());

        if (dbUser.isPresent() &&
            dbUser.get().getPassword().equals(user.getPassword())) {

            return jwtUtil.generateToken(
                    dbUser.get().getUsername(),
                    dbUser.get().getRole().name()
            );
        }

        return "Invalid credentials";
    }
}