package com.will_vila_be.Demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.will_vila_be.Demo.model.User;
import com.will_vila_be.Demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> createUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<Object> getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "User not found"), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> updateUser(int id, User updatedUser) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "User not found"), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(Map.of("message", "User deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "User not found"), HttpStatus.NOT_FOUND);
        }
    }
}
