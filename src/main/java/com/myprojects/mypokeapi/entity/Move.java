package com.myprojects.mypokeapi.entity;

import com.myprojects.mypokeapi.enums.MoveType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "move")
@Data
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MoveType type;

    private int power;
    private int accuracy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;
}
