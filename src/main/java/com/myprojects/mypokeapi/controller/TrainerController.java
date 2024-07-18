package com.myprojects.mypokeapi.controller;

import com.myprojects.mypokeapi.entity.Pokemon;
import com.myprojects.mypokeapi.entity.Region;
import com.myprojects.mypokeapi.entity.Trainer;
import com.myprojects.mypokeapi.service.PokemonService;
import com.myprojects.mypokeapi.service.RegionService;
import com.myprojects.mypokeapi.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

    private final TrainerService trainerService;
    private final PokemonService pokemonService;
    private final RegionService regionService;

    @Autowired
    public TrainerController(TrainerService trainerService, PokemonService pokemonService, RegionService regionService) {
        this.trainerService = trainerService;
        this.pokemonService = pokemonService;
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        return ResponseEntity.ok(trainers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        Trainer trainer = trainerService.getTrainerById(id);
        return ResponseEntity.ok(trainer);
    }

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        Trainer savedTrainer = trainerService.saveTrainer(trainer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{trainerId}/choose-pokemon")
    public ResponseEntity<Pokemon> choosePokemon(@PathVariable Long trainerId, @RequestParam Long regionId) {
        Trainer trainer = trainerService.getTrainerById(trainerId);
        Region region = regionService.getRegionById(regionId);

        // Aquí se puede agregar lógica para seleccionar un Pokémon aleatorio de la región
        List<Pokemon> pokemons = region.getPokemons();
        Pokemon chosenPokemon = pokemons.get(0); // Por ahora, seleccionar el primer Pokémon de la lista

        chosenPokemon.setTrainer(trainer);
        Pokemon savedPokemon = pokemonService.savePokemon(chosenPokemon);

        return ResponseEntity.ok(savedPokemon);
    }
}
