package com.myprojects.mypokeapi.service;

import com.myprojects.mypokeapi.dto.PokemonDTO;
import com.myprojects.mypokeapi.entity.Pokemon;
import com.myprojects.mypokeapi.repository.PokemonRepository;
//import com.myprojects.mypokeapi.util.AppConstants;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Page<Pokemon> getAllPokemons(Pageable pageable) {
        return pokemonRepository.findAll(pageable);
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon createPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(Pokemon.Type.valueOf(pokemonDTO.getType().toUpperCase()));
        return pokemonRepository.save(pokemon);
    }

    public Pokemon updatePokemon(Long id, PokemonDTO pokemonDTO) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            if (pokemonDTO.getName() != null) {
                pokemon.setName(pokemonDTO.getName());
            }
            if (pokemonDTO.getType() != null) {
                pokemon.setType(Pokemon.Type.valueOf(pokemonDTO.getType().toUpperCase()));
            }
            return pokemonRepository.save(pokemon);
        }
        throw new RuntimeException("Pokemon not found with id " + id);
    }

    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }
}