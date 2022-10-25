package com.example.fullstack.controller;

import com.example.fullstack.exception.UserNotFoundException;
import com.example.fullstack.model.User;
import com.example.fullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return  userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){

        return  userRepository.findAll();

    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Integer id){
        return  userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


}
