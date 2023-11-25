package com.github.userservice.repository;

import com.github.userservice.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findById(long id);

    void deleteById(long id);
}
