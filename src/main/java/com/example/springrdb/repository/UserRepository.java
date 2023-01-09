package com.example.springrdb.repository;

import com.example.springrdb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
    List<User> findAllByName(String name);
}
