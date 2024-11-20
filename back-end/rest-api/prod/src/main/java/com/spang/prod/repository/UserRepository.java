package com.spang.prod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spang.prod.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
