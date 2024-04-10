package com.application.JWT.controller;


import com.application.JWT.service.DatabaseUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private final DatabaseUserDetailsService userDetailsService;

    @Autowired
    public AuthController(DatabaseUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //    @PostMapping("/api/auth/register")
//    public String register(User user) {
//        UserDetails details = userDetailsService.loadUserByUsername(user.getName());
//        return "register";
//    }
    @GetMapping(value = "/api/test")
    public String test(@RequestParam("username") String username,
                       @RequestParam("password") String password) {
        return "test";
    }

    @GetMapping("/api/auth/logout")
    public String logout() {
        return "logout";
    }
}
