package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.SubscriptionPlan;
import com.example.repo.SubscriptionPlanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionPlanService {
    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public List<SubscriptionPlan> getAllSubscriptionPlans() {
        return subscriptionPlanRepository.findAll();
    }

    public Optional<SubscriptionPlan> getSubscriptionPlanById(Long id) {
        return subscriptionPlanRepository.findById(id);
    }

    public SubscriptionPlan addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanRepository.save(subscriptionPlan);
    }

    public SubscriptionPlan editSubscriptionPlan(Long id, SubscriptionPlan updatedSubscriptionPlan) {
        Optional<SubscriptionPlan> existingSubscriptionPlan = subscriptionPlanRepository.findById(id);

        if (existingSubscriptionPlan.isPresent()) {
            SubscriptionPlan subscriptionPlanToUpdate = existingSubscriptionPlan.get();
            subscriptionPlanToUpdate.setName(updatedSubscriptionPlan.getName());
            subscriptionPlanToUpdate.setDescription(updatedSubscriptionPlan.getDescription());
            subscriptionPlanToUpdate.setPrice(updatedSubscriptionPlan.getPrice());

            return subscriptionPlanRepository.save(subscriptionPlanToUpdate);
        }
        return null;
    }

    public void deleteSubscriptionPlan(Long id) {
        subscriptionPlanRepository.deleteById(id);
    }
}

