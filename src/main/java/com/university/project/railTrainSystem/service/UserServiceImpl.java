package com.university.project.railTrainSystem.service;

import com.university.project.railTrainSystem.entity.User;
import com.university.project.railTrainSystem.repository.UserRepository;
import com.university.project.railTrainSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User createAccount(String firstName, String lastName, String mail, String password) {
        try {
            User newUser = new User(firstName, lastName, mail, password);
            return repository.save(newUser);
        } catch (Exception e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            throw new RuntimeException("Error creating account: " + e.getMessage(), e);
        }
    }

    public void deleteAccount(String email) {
        try {
            repository.delete(getUser(email));
        } catch (Exception e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            throw new RuntimeException("Error deleting account: " + e.getMessage(), e);
        }
    }


    public User getUser(String email) {
        try {
            List<User> all = repository.findAll();
            for (User user : all) {
                if (user.getEmail().equals(email)) {
                    System.out.println(user);
                    return user;
                }
            }
            return null;
        } catch (Exception e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            throw new RuntimeException("Error getting user: " + e.getMessage(), e);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            throw new RuntimeException("Error getting all users: " + e.getMessage(), e);
        }
    }

}
