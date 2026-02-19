package com.example.First;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
