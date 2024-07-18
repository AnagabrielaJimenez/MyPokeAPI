package com.myprojects.mypokeapi.entity;

import com.myprojects.mypokeapi.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "trainer")
@Data
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pokemon> pokemons;
}
