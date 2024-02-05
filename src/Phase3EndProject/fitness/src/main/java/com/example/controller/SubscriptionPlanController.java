package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fitness.SubscriptionPlan;
import com.example.service.SubscriptionPlanService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscription-plans")
public class SubscriptionPlanController {
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @GetMapping
    public ResponseEntity<List<SubscriptionPlan>> getAllSubscriptionPlans() {
        List<SubscriptionPlan> subscriptionPlans = subscriptionPlanService.getAllSubscriptionPlans();
        return new ResponseEntity<>(subscriptionPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> getSubscriptionPlanById(@PathVariable Long id) {
        Optional<SubscriptionPlan> subscriptionPlan = subscriptionPlanService.getSubscriptionPlanById(id);
        return subscriptionPlan.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<SubscriptionPlan> addSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan) {
        SubscriptionPlan addedSubscriptionPlan = subscriptionPlanService.addSubscriptionPlan(subscriptionPlan);
        return new ResponseEntity<>(addedSubscriptionPlan, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<SubscriptionPlan> editSubscriptionPlan(@PathVariable Long id, @RequestBody SubscriptionPlan updatedSubscriptionPlan) {
        SubscriptionPlan editedSubscriptionPlan = subscriptionPlanService.editSubscriptionPlan(id, updatedSubscriptionPlan);
        return editedSubscriptionPlan != null ?
                new ResponseEntity<>(editedSubscriptionPlan, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubscriptionPlan(@PathVariable Long id) {
        subscriptionPlanService.deleteSubscriptionPlan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

