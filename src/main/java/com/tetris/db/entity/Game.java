package com.tetris.db.entity;

import com.tetris.model.GameState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Data
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int gameId;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private GameState state;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "figure",
            joinColumns = {@JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name = "figure_type_id")}
    )
    private List<FigureType> figures;


    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Move> moves;


}
