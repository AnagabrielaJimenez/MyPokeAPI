package com.myprojects.mypokeapi.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class PokemonDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String type;
}