package com.myprojects.mypokeapi.repository;

import com.myprojects.mypokeapi.entity.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Page<Pokemon> findByType(Pokemon.Type typeFilter, Pageable pageable);

    Page<Pokemon> findByNameContainingIgnoreCase(String nameFilter, Pageable pageable);

    Page<Pokemon> findByNameContainingIgnoreCaseAndType(String nameFilter, Pokemon.Type typeFilter, Pageable pageable);
}
