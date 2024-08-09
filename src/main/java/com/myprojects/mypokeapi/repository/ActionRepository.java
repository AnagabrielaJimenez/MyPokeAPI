package com.myprojects.mypokeapi.repository;

import com.myprojects.mypokeapi.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findByCombatId(Long combatId);
}
