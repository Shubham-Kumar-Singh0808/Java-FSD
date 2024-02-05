package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness.Trainer;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    List<Trainer> findByFullName(String fullName);
}

