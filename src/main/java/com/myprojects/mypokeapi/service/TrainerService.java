package com.myprojects.mypokeapi.service;

import com.myprojects.mypokeapi.entity.Trainer;
import com.myprojects.mypokeapi.exception.ResourceNotFoundException;
import com.myprojects.mypokeapi.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found"));
    }

    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}
