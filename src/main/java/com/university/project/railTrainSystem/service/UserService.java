package com.university.project.railTrainSystem.service;

import com.university.project.railTrainSystem.entity.User;

import java.util.List;

public interface UserService {
    User createAccount(String firstName, String lastName, String password, String email);
    void deleteAccount(String email);
    boolean checkIfExistAccount(String email);
     User getUser(String email);

     List<User> getAll();

}
