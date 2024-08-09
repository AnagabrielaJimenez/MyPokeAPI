package com.myprojects.mypokeapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.myprojects.mypokeapi.enums.CombatType;
//import javax.swing.*;
import java.util.List;

@Entity
@Table(name = "combat")
@Data
public class Combat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenger_id")
    private Trainer challenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opponent_id")
    private Trainer opponent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id")
    private Trainer winner;

    @OneToMany(mappedBy = "combat", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("order ASC")
    private List<Action> actions;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CombatType combatType;
}
