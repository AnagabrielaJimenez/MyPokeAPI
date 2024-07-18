package com.myprojects.mypokeapi.controller;

import com.myprojects.mypokeapi.entity.Move;
import com.myprojects.mypokeapi.service.MoveService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moves")
public class MoveController {

    private final MoveService moveService;

    @Autowired
    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @GetMapping
    public ResponseEntity<List<Move>> getAllMoves() {
        List<Move> moves = moveService.getAllMoves();
        return ResponseEntity.ok(moves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Move> getMoveById(@PathVariable Long id) {
        Move move = moveService.getMoveById(id);
        return ResponseEntity.ok(move);
    }

    @PostMapping
    public ResponseEntity<Move> createMove(@RequestBody Move move) {
        Move savedMove = moveService.saveMove(move);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMove);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMove(@PathVariable Long id) {
        moveService.deleteMove(id);
        return ResponseEntity.noContent().build();
    }
}
