package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fitness.Subscriber;
import com.example.service.SubscriberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscribers")
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    @GetMapping
    public ResponseEntity<List<Subscriber>> getAllSubscribers() {
        List<Subscriber> subscribers = subscriberService.getAllSubscribers();
        return new ResponseEntity<>(subscribers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscriber> getSubscriberById(@PathVariable Long id) {
        Optional<Subscriber> subscriber = subscriberService.getSubscriberById(id);

        return subscriber.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<Subscriber> addSubscriber(@RequestBody Subscriber subscriber) {
        Subscriber addedSubscriber = subscriberService.addSubscriber(subscriber);

        return new ResponseEntity<>(addedSubscriber, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Subscriber> editSubscriber(@PathVariable Long id, @RequestBody Subscriber updatedSubscriber) {
        Subscriber editedSubscriber = subscriberService.editSubscriber(id, updatedSubscriber);

        return editedSubscriber != null ?
                new ResponseEntity<>(editedSubscriber, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubscriber(@PathVariable Long id) {
        subscriberService.deleteSubscriber(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

