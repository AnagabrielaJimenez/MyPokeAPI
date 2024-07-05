package com.myprojects.mypokeapi.config;

import com.myprojects.mypokeapi.entity.Pokemon;
import com.myprojects.mypokeapi.repository.PokemonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PokemonRepository pokemonRepository;

    public DataInitializer(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public void run(String... args) {
        // Initialize some sample data
        if (pokemonRepository.count() == 0) {
            Pokemon pikachu = new Pokemon();
            pikachu.setName("Pikachu");
            pikachu.setType(Pokemon.Type.ELECTRIC);
            pokemonRepository.save(pikachu);

            Pokemon bulbasaur = new Pokemon();
            bulbasaur.setName("Bulbasaur");
            bulbasaur.setType(Pokemon.Type.GRASS);
            pokemonRepository.save(bulbasaur);
        }
    }
}
