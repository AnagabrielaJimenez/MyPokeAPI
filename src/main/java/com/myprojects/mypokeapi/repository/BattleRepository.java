package com.myprojects.mypokeapi.repository;

import com.myprojects.mypokeapi.entity.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Long> {
}
