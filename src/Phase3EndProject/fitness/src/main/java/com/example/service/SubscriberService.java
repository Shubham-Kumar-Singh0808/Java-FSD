package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.Subscriber;
import com.example.repo.SubscriberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService {
    @Autowired
    private SubscriberRepository subscriberRepository;

    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }

    public Optional<Subscriber> getSubscriberById(Long id) {
        return subscriberRepository.findById(id);
    }

    public Subscriber addSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    public Subscriber editSubscriber(Long id, Subscriber updatedSubscriber) {
        // Check if the subscriber with the given id exists
        Optional<Subscriber> existingSubscriber = subscriberRepository.findById(id);

        if (existingSubscriber.isPresent()) {
            // Update the existing subscriber with the new data
            Subscriber subscriberToUpdate = existingSubscriber.get();
            subscriberToUpdate.setFullName(updatedSubscriber.getFullName());
            subscriberToUpdate.setMobileNumber(updatedSubscriber.getMobileNumber());
            subscriberToUpdate.setEmail(updatedSubscriber.getEmail());
            subscriberToUpdate.setAddress(updatedSubscriber.getAddress());

            return subscriberRepository.save(subscriberToUpdate);
        }

        // Handle the case where the subscriber with the given id doesn't exist
        return null;
    }

    public void deleteSubscriber(Long id) {
        subscriberRepository.deleteById(id);
    }
}

