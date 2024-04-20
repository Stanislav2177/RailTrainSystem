package com.university.project.railTrainSystem.controller;


import com.university.project.railTrainSystem.entity.User;
import com.university.project.railTrainSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService service;


    @PostMapping("/create")
    public void createUser(@RequestBody User user){
        service.createAccount(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

    @GetMapping("/get/email")
    public ResponseEntity<User> getUser(@RequestParam String email){
        User user = service.getUser(email);
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/email")
    public ResponseEntity<Void> deleteUser(@RequestParam String email){
        service.deleteAccount(email);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }



}
