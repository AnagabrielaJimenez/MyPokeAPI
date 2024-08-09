package com.myprojects.mypokeapi.controller;

import com.myprojects.mypokeapi.entity.Action;
import com.myprojects.mypokeapi.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actions")
public class ActionController {

    private final ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping
    public ResponseEntity<Action> createAction(@RequestBody Action action) {
        Action savedAction = actionService.saveAction(action);
        return new ResponseEntity<>(savedAction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getActionById(@PathVariable Long id) {
        Optional<Action> action = actionService.getActionById(id);
        return action.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/combat/{combatId}")
    public ResponseEntity<List<Action>> getActionsByCombatId(@PathVariable Long combatId) {
        List<Action> actions = actionService.getActionsByCombatId(combatId);
        return new ResponseEntity<>(actions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
