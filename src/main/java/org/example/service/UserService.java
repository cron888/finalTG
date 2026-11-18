package org.example.service;

import org.example.entity.User;
import org.example.exception.UserNotFoundException;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User resolveUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден: " + username);
        }
        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
