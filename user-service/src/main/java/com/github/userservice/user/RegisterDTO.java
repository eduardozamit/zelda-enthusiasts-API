package com.github.userservice.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
