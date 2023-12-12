package com.github.userservice.service;

import com.github.userservice.models.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        List<UserModel> userList = Arrays.asList(
                new UserModel(1L, "Arthur", 20),
                new UserModel(2L, "Zamit", 21)
        );
        when(userRepository.findAll()).thenReturn(userList);

        // Act
        List<UserModel> result = userService.getAllUsers();

        // Assert
        assertEquals(userList, result);
    }

    @Test
    void testGetUserById() {
        // Arrange
        long userId = 1L;
        UserModel user = new UserModel(userId, "Alice", 25);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        Optional<UserModel> result = userService.getUserById(userId);

        // Assert
        assertEquals(Optional.of(user), result);
    }

    @Test
    void testCreateUser() {
        // Arrange
        UserModel newUser = new UserModel(null, "Bob", 30);
        UserModel savedUser = new UserModel(1L, "Bob", 30);
        when(userRepository.save(any(UserModel.class))).thenReturn(savedUser);

        // Act
        UserModel result = userService.createUser(newUser);

        // Assert
        assertEquals(savedUser, result);
    }

    @Test
    void testUpdateUser() {
        // Arrange
        long userId = 1L;
        UserModel existingUser = new UserModel(userId, "Alice", 25);
        UserModel updatedUser = new UserModel(userId, "Alicia", 26);
        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(UserModel.class))).thenReturn(updatedUser);

        // Act
        UserModel result = userService.updateUser(userId, updatedUser);

        // Assert
        assertEquals(updatedUser, result);
    }

    @Test
    void testUpdateUser_UserNotFound() {
        // Arrange
        long userId = 1L;
        UserModel updatedUser = new UserModel(userId, "Alicia", 26);
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        UserModel result = userService.updateUser(userId, updatedUser);

        // Assert
        assertNull(result);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        long userId = 1L;

        // Act
        userService.deleteUser(userId);

        // Assert
        verify(userRepository, times(1)).deleteById(userId);
    }


}

