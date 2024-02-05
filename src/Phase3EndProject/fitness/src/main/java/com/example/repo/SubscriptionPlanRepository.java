package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness.SubscriptionPlan;

import java.util.List;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
    List<SubscriptionPlan> findByName(String name);
}

