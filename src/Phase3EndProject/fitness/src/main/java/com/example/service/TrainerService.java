package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.Trainer;
import com.example.repo.TrainerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Optional<Trainer> getTrainerById(Long id) {
        return trainerRepository.findById(id);
    }

    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer editTrainer(Long id, Trainer updatedTrainer) {
        Optional<Trainer> existingTrainer = trainerRepository.findById(id);

        if (existingTrainer.isPresent()) {
            Trainer trainerToUpdate = existingTrainer.get();
            trainerToUpdate.setFullName(updatedTrainer.getFullName());
            trainerToUpdate.setAge(updatedTrainer.getAge());
            trainerToUpdate.setGender(updatedTrainer.getGender());
            trainerToUpdate.setYearsOfExperience(updatedTrainer.getYearsOfExperience());

            return trainerRepository.save(trainerToUpdate);
        }
        return null;
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}

