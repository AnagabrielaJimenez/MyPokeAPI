package com.myprojects.mypokeapi.service;

import com.myprojects.mypokeapi.entity.Action;
import com.myprojects.mypokeapi.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    private final ActionRepository actionRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public Action saveAction(Action action) {
        return actionRepository.save(action);
    }

    public Optional<Action> getActionById(Long id) {
        return actionRepository.findById(id);
    }

    public List<Action> getActionsByCombatId(Long combatId) {
        return actionRepository.findByCombatId(combatId);
    }

    public void deleteAction(Long id) {
        actionRepository.deleteById(id);
    }

}
