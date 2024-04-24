package com.university.project.railTrainSystem.testservice.userService;
import com.university.project.railTrainSystem.entity.User;
import com.university.project.railTrainSystem.repository.UserRepository;
import com.university.project.railTrainSystem.service.UserService;
import com.university.project.railTrainSystem.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testCreateAccount() {
            User newUser = new User("Stan", "Yankov", "stan@test.com", "password");

        when(repository.save(any(User.class))).thenReturn(newUser);

        User createdUser = userService.createAccount("Stan", "Yankov", "stan@test.com", "password");

        assertNotNull(createdUser);
        assertEquals("Stan", createdUser.getFirstName());
        assertEquals("Yankov", createdUser.getLastName());
        assertEquals("stan@test.com", createdUser.getEmail());
        assertEquals("password", createdUser.getPassword());
        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    void testGetUser() {
        String existingEmail = "stan@test.com";
        User user1 = new User("Stan", "Yankov", "stan@test.com", "password");
        User user2 = new User("Stan", "Yankov", "stan@test.com", "password");

        when(repository.findAll()).thenReturn(Arrays.asList(user1));
        when(repository.findAll()).thenReturn(Arrays.asList(user1));

        User foundUser = userService.getUser(existingEmail);

        assertNotNull(foundUser);
        assertEquals("Stan", foundUser.getFirstName());
        assertEquals("Yankov", foundUser.getLastName());
        assertEquals("stan@test.com", foundUser.getEmail());
        assertEquals("password", foundUser.getPassword());
        verify(repository, times(1)).findAll();


    }

    @Test
    void testGetAll() {
        User user1 = new User("Stan", "Yankov", "stan@test.com", "password");
        User user2 = new User("Stanislav", "Yankov", "stan1@test.com", "password");

        when(repository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> allUsers = userService.getAll();

        assertNotNull(allUsers);
        assertEquals(2, allUsers.size());
        assertEquals("stan@test.com", allUsers.get(0).getEmail());
        assertEquals("stan1@test.com", allUsers.get(1).getEmail());
        verify(repository, times(1)).findAll();
    }

}

