package com.university.project.railTrainSystem.service;

import com.university.project.railTrainSystem.entity.User;
import com.university.project.railTrainSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;


    public User createAccount(String firstName, String lastName, String mail, String password) {
        User newUser = new User(firstName, lastName, mail, password);
        return repository.save(newUser);
    }


    public void deleteAccount(String email) {
        repository.delete(getUser(email));
    }


    public boolean checkIfExistAccount(String email){
        return repository.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .isParallel();
    }

    public User getUser(String email){
        List<User> all = repository.findAll();
        for (User user : all) {
            if(user.getEmail().equals(email)){
                System.out.println(user);
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
