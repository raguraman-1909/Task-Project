package com.TaskProject.service;

import com.TaskProject.model.User;
import com.TaskProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> createUser(User user) {

        if (!isUserEmailPresent(user.getEmail())) {
            return Optional.of(userRepository.save(user));
        } else {
            return Optional.empty(); // User with the same email already exists
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isUserEmailPresent(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
