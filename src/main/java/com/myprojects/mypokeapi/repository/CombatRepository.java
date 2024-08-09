package com.myprojects.mypokeapi.repository;

import com.myprojects.mypokeapi.entity.Combat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombatRepository extends JpaRepository<Combat, Long> {
}
