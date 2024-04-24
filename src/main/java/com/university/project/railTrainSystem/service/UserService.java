package com.university.project.railTrainSystem.service;

import com.university.project.railTrainSystem.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createAccount(String firstName, String lastName, String password, String email);
    void deleteAccount(String email);

     User getUser(String email);

     List<User> getAll();

}
