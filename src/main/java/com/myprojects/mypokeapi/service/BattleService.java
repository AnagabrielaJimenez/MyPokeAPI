package com.myprojects.mypokeapi.service;

import com.myprojects.mypokeapi.entity.Battle;
import com.myprojects.mypokeapi.exception.ResourceNotFoundException;
import com.myprojects.mypokeapi.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {

    private final BattleRepository battleRepository;

    @Autowired
    public BattleService(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    public List<Battle> getAllBattles() {
        return battleRepository.findAll();
    }

    public Battle getBattleById(Long id) {
        return battleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Battle not found"));
    }

    public Battle saveBattle(Battle battle) {
        return battleRepository.save(battle);
    }

    public void deleteBattle(Long id) {
        battleRepository.deleteById(id);
    }
}
