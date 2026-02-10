package com.example.koztos_backend.repository;

import com.example.koztos_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByDni(String dni);
    Optional<User> findByDni(String dni);
    List<User> findByRole_Name(String roleName);
    Optional<User> findByUsername(String username);
}
