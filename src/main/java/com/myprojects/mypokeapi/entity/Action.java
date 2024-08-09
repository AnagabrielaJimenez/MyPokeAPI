package com.myprojects.mypokeapi.entity;

import com.myprojects.mypokeapi.enums.ActionType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "action")
@Data
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "combat_id")
    private Combat combat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActionType actionType;

    private String description;
    private int order;
}
