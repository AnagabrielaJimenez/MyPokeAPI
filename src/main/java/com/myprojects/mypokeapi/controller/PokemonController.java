package com.myprojects.mypokeapi.controller;

import com.myprojects.mypokeapi.dto.PokemonDTO;
import com.myprojects.mypokeapi.entity.Pokemon;
import com.myprojects.mypokeapi.service.PokemonService;
import com.myprojects.mypokeapi.util.AppConstants;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<Page<Pokemon>> getAllPokemons(
            @RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Pokemon> resultPage = pokemonService.getAllPokemons(pageable);
        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(id);
        return pokemon.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@Valid @RequestBody PokemonDTO pokemonDTO) {
        Pokemon createdPokemon = pokemonService.createPokemon(pokemonDTO);
        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable Long id, @Valid @RequestBody PokemonDTO pokemonDTO) {
        Pokemon updatedPokemon = pokemonService.updatePokemon(id, pokemonDTO);
        return new ResponseEntity<>(updatedPokemon, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}