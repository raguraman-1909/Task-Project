package com.TaskProject.service;

import com.TaskProject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> createUser(User user);

    List<User> findAll();

    User getUserByEmail(String email);

    boolean isUserEmailPresent(String email);

    Optional<User> getUserById(Long userId);

    void deleteUser(Long id);
}
