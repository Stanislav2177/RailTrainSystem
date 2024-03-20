package com.university.project.railTrainSystem.repository;

import com.university.project.railTrainSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByEmail(String email);
//    Optional<User> findByUsername(String username);

}