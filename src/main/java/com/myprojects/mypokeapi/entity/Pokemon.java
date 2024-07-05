package com.myprojects.mypokeapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;

    public enum Type {
        FIRE, WATER, GRASS, ELECTRIC, ROCK, GROUND, PSYCHIC, NORMAL
    }
}
