package com.fitness_center.repositories;


import com.fitness_center.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<com.fitness_center.entities.User> findByEmail(String email);
    boolean existsByEmail(String email);
}

