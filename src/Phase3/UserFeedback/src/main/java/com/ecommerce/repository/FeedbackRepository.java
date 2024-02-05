package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    // Any additional custom query methods can be added here
}

