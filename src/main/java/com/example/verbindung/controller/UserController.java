package com.example.verbindung.controller;
import com.example.verbindung.UserData;
import com.example.verbindung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.verbindung.model.User;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public boolean registerUser(@RequestBody UserData userData) {
        System.out.println("Register API called");
        User registeredUser = userService.registerNewUser(userData);
        System.out.println("Registered new User "+registeredUser.toString());
        return true;
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return user
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserData userData){
        try {
            System.out.println("Login API called");
            String email = userData.getEmail();
            String password = userData.getPassword();
            return userService.login(email,password);
        }catch (Exception e){
            System.out.println("Login Exception");
            return false;
        }
    }
}
