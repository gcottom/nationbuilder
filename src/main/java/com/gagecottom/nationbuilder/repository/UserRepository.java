package com.gagecottom.nationbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gagecottom.nationbuilder.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
