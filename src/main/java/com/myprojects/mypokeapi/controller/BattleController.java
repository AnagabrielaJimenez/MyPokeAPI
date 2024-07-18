package com.myprojects.mypokeapi.controller;

import com.myprojects.mypokeapi.entity.Battle;
import com.myprojects.mypokeapi.service.BattleService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/battles")
public class BattleController {

    private final BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @GetMapping
    public ResponseEntity<List<Battle>> getAllBattles() {
        List<Battle> battles = battleService.getAllBattles();
        return ResponseEntity.ok(battles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Battle> getBattleById(@PathVariable Long id) {
        Battle battle = battleService.getBattleById(id);
        return ResponseEntity.ok(battle);
    }

    @PostMapping
    public ResponseEntity<Battle> createBattle(@RequestBody Battle battle) {
        Battle savedBattle = battleService.saveBattle(battle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBattle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBattle(@PathVariable Long id) {
        battleService.deleteBattle(id);
        return ResponseEntity.noContent().build();
    }
}
