package com.myprojects.mypokeapi.controller;

import com.myprojects.mypokeapi.entity.Combat;
import com.myprojects.mypokeapi.enums.CombatType;
import com.myprojects.mypokeapi.service.CombatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/combats")
public class CombatController {

    private final CombatService combatService;

    @Autowired
    public CombatController(CombatService combatService) {
        this.combatService = combatService;
    }

    @PostMapping("/challenge")
    public ResponseEntity<Combat> challengeTrainer(
            @RequestParam Long challengerId,
            @RequestParam Long opponentId,
            @RequestParam CombatType combatType) {

        Combat combat = combatService.createCombat(challengerId, opponentId, combatType);
        return ResponseEntity.status(201).body(combat);
    }
}
