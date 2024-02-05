package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitness.Subscriber;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    // Custom query method to find subscriber by email
    Optional<Subscriber> findByEmail(String email);
    Optional<List<Subscriber>> findByFullName(String fullName);
    Optional<List<Subscriber>> findByMobileNumber(String mobileNumber);
}

