package com.example.verbindung.service;

import com.example.verbindung.UserContext;
import com.example.verbindung.UserData;
import com.example.verbindung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.verbindung.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private UserContext userContext;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerNewUser(UserData userData) {
        System.out.println("registerNewUser entered");
        User user = new User("löschen?", passwordEncoder.encode(userData.getPassword()), userData.getEmail());
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public boolean login(String email, String password){

        System.out.println("geiloooo");
        if(findByEmail(email).isPresent()){
            if(passwordEncoder.matches(password,findByEmail(email).get().getPassword())){
                System.out.println("true");

                UserContext.setLoggedInUser(findByEmail(email).get());
                //System.out.println("TestUserLoggedIn"+ userContext.getLoggedInUser());
                return true;
            }
        }
        System.out.println("false");
        return false;

    }
}