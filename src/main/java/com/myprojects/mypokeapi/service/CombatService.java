package com.myprojects.mypokeapi.service;

import com.myprojects.mypokeapi.entity.Combat;
import com.myprojects.mypokeapi.entity.Trainer;
import com.myprojects.mypokeapi.enums.CombatType;
import com.myprojects.mypokeapi.exception.ResourceNotFoundException;
import com.myprojects.mypokeapi.repository.CombatRepository;
import com.myprojects.mypokeapi.repository.TrainerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombatService {

    private final CombatRepository combatRepository;
    private final TrainerRepository trainerRepository;

    @Autowired
    public CombatService(CombatRepository combatRepository, TrainerRepository trainerRepository) {
        this.combatRepository = combatRepository;
        this.trainerRepository = trainerRepository;
    }

    public Combat createCombat(Long challengerId, Long opponentId, CombatType combatType) {
        Trainer challenger = trainerRepository.findById(challengerId)
                .orElseThrow(() -> new ResourceNotFoundException("Challenger not found"));
        Trainer opponent = trainerRepository.findById(opponentId)
                .orElseThrow(() -> new ResourceNotFoundException("Opponent not found"));

        // Validar que ambos entrenadores tengan los Pokémon necesarios
        if (combatType == CombatType.CASUAL && (challenger.getPokemons().size() < 3 || opponent.getPokemons().size() < 3)) {
            throw new IllegalArgumentException("Both trainers must have at least 3 Pokémon for a casual combat");
        } else if (combatType == CombatType.PROFESSIONAL && (challenger.getPokemons().size() < 6 || opponent.getPokemons().size() < 6)) {
            throw new IllegalArgumentException("Both trainers must have at least 6 Pokémon for a professional combat");
        }

        // Validar niveles de los Pokémon (ejemplo simple)
        challenger.getPokemons().forEach(pokemon -> {
            if (pokemon.getLevel() < 5) {
                throw new IllegalArgumentException("All Pokémon must be at least level 5 to participate in a combat");
            }
        });
        opponent.getPokemons().forEach(pokemon -> {
            if (pokemon.getLevel() < 5) {
                throw new IllegalArgumentException("All Pokémon must be at least level 5 to participate in a combat");
            }
        });

        Combat combat = new Combat();
        combat.setChallenger(challenger);
        combat.setOpponent(opponent);
        combat.setCombatType(combatType);

        return combatRepository.save(combat);
    }

}
