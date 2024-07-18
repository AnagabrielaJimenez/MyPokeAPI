package com.myprojects.mypokeapi.service;

import com.myprojects.mypokeapi.entity.Move;
import com.myprojects.mypokeapi.exception.ResourceNotFoundException;
import com.myprojects.mypokeapi.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {

    private final MoveRepository moveRepository;

    @Autowired
    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public List<Move> getAllMoves() {
        return moveRepository.findAll();
    }

    public Move getMoveById(Long id) {
        return moveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Move not found"));
    }

    public Move saveMove(Move move) {
        return moveRepository.save(move);
    }

    public void deleteMove(Long id) {
        moveRepository.deleteById(id);
    }
}