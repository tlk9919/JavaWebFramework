package com.starwhisper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.starwhisper.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}