package com.github.userservice.service;

import com.github.userservice.models.UserModel;
import com.github.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public UserModel updateUser(Long userId, UserModel updatedUser) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setAge((updatedUser.getAge()));
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
